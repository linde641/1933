/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw3;

/**
 *
 * @author paidforbyoptions
 */
public class MyArrayStack<T> extends MyArrayList<T>
{
    //T[] data = getArrayOfSize(10);
    
//    @Override
//    public int getSize()
//    {
//        int size = 0;
//        int i = 0;
//        while (data[i] != null)
//        {
//            size++;
//            i++;
//        }
//        return size;
//       
//    }
    
    public T pop()
    {
        T output = data[0];
        int size = getSize();
        for (int i = 0; i < size; i++)
        {
            data[i] = data[i+1];
        }
        //data[getSize()] = null;
        return output;
    }
    
    public T peek()
    {
        return data[0];
    }
    
    public void push(T item)
    {
        if (getSize() == data.length - 1)
        {
            grow();
        }
        int size = getSize();
        
        for (int i = size - 1; i >= 0; i = i - 1)
        {
            
            data[i+1] = data[i];
        }
        
        data[0] = item;
        
//        System.out.println("array starts here: ");
//        System.out.println(data[0]);
//        System.out.println(data[1]);
//        System.out.println(data[2]);
//        System.out.println(data[3]);
//        System.out.println("size is : ");
//        System.out.println(getSize());
    }
    
    @Override
    public void clear()
    {
        for (int i = 0; i < getSize(); i++)
        {
            data[i] = null;
        }
    }
    
    public boolean isEmpty()
    {
        return data[0] == null;
    }
    
    private T[] getArrayOfSize(int capacity)
	{
		T[] newSpace = (T[]) new Object[capacity];
		return newSpace;
	}
}
