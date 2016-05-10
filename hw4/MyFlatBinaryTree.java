package hw4;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author
 */
public class MyFlatBinaryTree<T>
{
	public T[] data;
        //int capacity; /// this is how many elements can be stored. The array length is capacity + 1 because first slot is empty
        
	//<editor-fold defaultstate="collapsed" desc="public API">
	public void addLevel()
	{
            int capacity = getCapacity();
            int newCapacity;
            if (null == data)
            {
                    newCapacity = 1;
                    data = (T[]) new Object[newCapacity + 1];
                    capacity = newCapacity;
                    return;
            }
            else
            {
                newCapacity = 2*capacity + 1;
                T[] newData = (T[]) new Object[newCapacity + 1];
                for (int i = 0; i < data.length; i++)
                {
                    newData[i] = data[i];
                }
                capacity = newCapacity;
                data = newData;
            }                

        }

	public T get(int index)
	{            
            if (index >= data.length)
            {
                    return null;
            }
            return data[index];
	}

	public int getCapacity()
	{
            if (data == null)
            {
                return 0;
            }
            int capacity = data.length - 1;
            return capacity;
	}

	public int getHeight()
	{
		//return getHeight(1);            
            int n = lastOccupiedIndex(); //previous capacity calculated from capacity = 2n + 1;
            int operations = 0;
            while (n > 1)
            {
                n = (n - 1)/2; /////IF ERRORING DO THIS WITH TEMP VARIABLE; NOT SURE IF IT WILL WORK OR NOT
                operations ++;
            }
            return operations + 1;
	}

	public int getNodeCountAtLevel(int level) ///everything will probably use this so check closely if stuff doesn't work
	{ //need to calculate the start and ending indices of the level            
            int count = 0;
            int start = 1; ///this is the start of the ith level
            int end = 1;   /// end of the ith level
            int prevEnd;
            for (int i = 1; i < level; i++)
            {   
                prevEnd = end;
                end = 2*end + 1; //last slot in ith level                                
                start = end - prevEnd;                
            }
            for (int i = start; i <= end; i++) // now go through that level and count how many are actually filled
            {
                if (data[i] != null)
                {
                    count++;
                }
            }
            return count;  
	}

	public int getNumberOfBranchNodes()//branches have at least one of the two slots after them filled
	{            
            return getNumberOfNodes() - getNumberOfLeaves();
	}

//	public int getNumberOfLeaves()//leaves will have two blanks immediately after them
//	{            
//            int leaves = 0;
//            int end = lastIndexOfLastLevel();            
//            List<Integer> list = indicesOfAllNodes();
//            for (Integer i : list)///careful for null pointers; alter the data.length if null pointers arise
//            {
//                if (2*i > end)
//                {
//                    leaves++;
//                    continue;
//                }
//                if (data[2*i] == null && data[2*i+1] == null)
//                {
//                    leaves++;
//                }                
//            }
//            return leaves++;
//	}
        public int getNumberOfLeaves()
        {
            int leaves = 0;
            for (int i = 1; i < data.length; i++)
            {
                if (isLeaf(i))
                {
                    leaves++;
                }
            }
            return leaves;
        }

	public int getNumberOfNodes()
	{
            int nodes = 0;
            for (int i = 0; i < data.length; i++)
            {
                if (data[i] != null)
                {
                    nodes++;
                }
            }
            return nodes;
	}

	public String getPostOrderStructure()
	{
            return getPostOrderStructure(1);
	}
        
        public String getPostOrderStructure(int index)
        {            
            String output = "";
            if (data[index] == null)
            {
                return output;
            }
            if (isLeaf(index))
            {
                return data[index].toString();
            }
            output = getPostOrderStructure(2*index) + output;
            output += getPostOrderStructure(2*index + 1);
            output += data[index];
            return output;
        }
        
        public String getPreOrderStructure()
        {
            return getPreOrderStructure(1);
        }
	public String getPreOrderStructure(int index)
	{
            if (data[index] == null)
            {
                return "";
            }
            if (isLeaf(index))
            {
                return data[index].toString();
            }
            String output = data[index].toString();
            output += getPreOrderStructure(2*index);
            output += getPreOrderStructure(2*index + 1);
            return output;            
	}

	public String getStructure()
	{
		return getStructure(1,1);
	}

	public void set(int index, T item)
	{
		data[index] = item;
	}
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="private version of API">


	private String getStructure(int currentNodeIndex, int level)
	{
		//--- Indent
		//--- Add decorator
		//--- Add my data
		//--- Add my kids
            String output = "";
            if (data[currentNodeIndex] == null)
            {
                return output;
            }            
            for (int i = 1; i < level; i++)
            {
                output += "    ";
            }
            output += "|-- " + data[currentNodeIndex].toString() + System.lineSeparator();
            
            if (isLeaf(currentNodeIndex) )
            {
                return output; //  "|-- " + data[currentNodeIndex].toString() + System.lineSeparator();
            }
            
            output += getStructure(currentNodeIndex*2, level + 1); //add structure of kid 1
            output += getStructure(currentNodeIndex*2 + 1, level + 1); // add structure of kid2
            return output;	
	}
//	//</editor-fold>
//
        
        public boolean isLeaf(int index)///this doesn't guarantee that each index is actually a node;
        {
            if (data[index] == null)
            {
                return false;
            }
            if (index*2 >= data.length)
            {
                return true;
            }
            return (data[index*2] == null && data[index*2 + 1] == null);
        }
        
        public int IndexOfLeftChild(int currentIndex)
        {
            return 2*currentIndex;
        }
        public int IndexOfRightChild(int currentIndex)
        {
            return 2*currentIndex + 1;
        }
        

	protected int getParentIndex(int currentNodeIndex)
	{
             double parent = Math.floor(currentNodeIndex/2);
             return (int) parent;
	}
        
        public int lastOccupiedIndex()
        {       
            int lastOccupiedIndex = 0;
            for (int i = 1; i < data.length; i++)
            {
                if (data[i] != null)
                {
                    lastOccupiedIndex = i;
                }                
            }
            return lastOccupiedIndex;
        }
        
        public int lastIndexOfLastLevel()
        {
            int n = getHeight();
            int capacity = 1;
            for (int i = 1; i < n; i++)
            {
                capacity = 2*capacity + 1; 
            }
            return capacity;
        }
        
        public List<Integer> indicesOfAllNodes()
        {
            LinkedList<Integer> list = new LinkedList<>();
            int end = lastIndexOfLastLevel();
            for (int i = 1; i <= end; i++)
            {
                if (data[i] != null)
                {
                    list.add(i);
                }
            }
            return list;
        }
        
//
//	protected boolean haveLeftChild(int currentNodeIndex)
//	{
//		return null != getLeftChild(currentNodeIndex);
//	}
//

	//</editor-fold>
}
