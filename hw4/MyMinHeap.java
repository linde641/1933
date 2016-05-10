/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw4;

import java.util.LinkedList;

/**
 *
 * @author paidforbyoptions
 */
public class MyMinHeap<T extends Comparable> extends MyFlatBinaryTree<T> implements MyHeap<T>
{
    protected int lastNodeIndex;
    
    
    @Override
    public T peek() 
    {
        return get(1);
    }

    @Override
    public T pop() 
    {
        T output = get(1);          // T output == data[1];
        set(1, get(lastNodeIndex));            //data[1] = data[lastNodeIndex];
        set(lastNodeIndex, null);   //data[lastNodeIndex] = null;
        lastNodeIndex--;
        sink(1);
        return output;        
    }

    @Override
    public void push(T item) 
    {
        if (lastNodeIndex == getCapacity())
            {
                addLevel();
            }
            
            //int firstEmptySlot = firstEmptySlot();
            set(lastNodeIndex + 1, item);              //data[firstEmptySlot] = item;
            lastNodeIndex++;
            rise(lastNodeIndex);        
    }

    @Override
    public boolean isEmpty() 
    {
        return get(1) == null;      //data[1] == null;
    }
    
    //<editor-fold defaultstate="collapsed" desc="helper methods">
	private void rise(int currentIndex)//called by push()
	{
            if (getParentIndex(currentIndex) == 0)///calling rise on root means node has risen to the top and should stop
            {
                return;///rose to the top;
            }
            if (!isBigger(get(getParentIndex(currentIndex)), get(currentIndex)))
            {
                return; //parent is smaller
            }
            
            swap(getParentIndex(currentIndex), currentIndex);
            rise(getParentIndex(currentIndex));///because the data was swapped already;            
	}

	private void sink(int currentIndex)//called by pop()
	{
            if (isEmpty())
            {
                return;
            }
            if (isLeaf(currentIndex))// can't sink any further
            {
                return;
            }
            if (!isBigger(get(currentIndex), get(getIndexOfSmallestChild(currentIndex))) )/// found the correct spot
            {
                return;
            }            
            
            int indexOfSmallestChild = getIndexOfSmallestChild(currentIndex);            
            swap(currentIndex, indexOfSmallestChild);
            sink(indexOfSmallestChild);
	}

        
        
	private int getIndexOfBiggestChild(int currentIndex)
	{
            int left = 2*currentIndex;
            int right = 2*currentIndex + 1;
            
            if (get(left).compareTo(get(right)) >= 0)
            {
                return left;
            }
            return right;
	}
        
        private int getIndexOfSmallestChild(int currentIndex)//pop will never call this on a leaf, so it must have a left child
        {
            int left = 2*currentIndex;
            int right = 2*currentIndex + 1;
            
            if (get(right) == null) //  this returns the left node index in the case that it only has a left child
            {//important to remember that heaps cant have a right child without having a left child
                return left;
            }
            
            if(get(left).compareTo(get(right)) <= 0)
            {
                return left;
            }
            return right;
        }

	private boolean isBigger(T a, T b)//or equal
	{
            if (a == null && b != null)
            {
                return false;
            }
            if (a != null && b == null)
            {
                return true;
            }
		return a.compareTo(b) >= 0;
	}

	private void swap(int a, int b)
	{
            T temp = get(a);
            set(a, get(b));        //data[a] = data[b];
            set(b, temp);           //data[b] = temp;
	}
        private int firstEmptySlot()
        {
            int slot = 0;
            int length = getCapacity() + 1; //because getCapacity() doesn't count the first slot which is empty
            for (int k = 0; k < length; k++)
            {
                if (get(k) != null)
                {
                    continue;
                }
                slot = k;
            }
            return slot;
        }
	//</editor-fold>

	
//	public String getStructure()
//	{
//                        
//            T popValue = pop();
//            LinkedList<T> list = new LinkedList<>();
//            String output = "";
//            while (popValue != null)
//            {         
//                output += popValue.toString() + " ";                
//                list.add(popValue);                
//                popValue = pop();
//            }
//            for (int i = 0; i < list.size(); i++)
//            {
//                push(list.get(i));
//            }
//            
//            return output.trim();
//	}
    public String getStructure()
    {
        String output = "";
        for (int i = 1; i <= lastNodeIndex; i++)
        {
            String element = get(i).toString();
            output += element + " ";
        }
        return output.trim();
    }
    @Override
    public String toString()
    {
        return getStructure();
    }
}
