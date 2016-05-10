package hw4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyGeneralTreeNode<T>
{
	T data;
	List<MyGeneralTreeNode<T>> children = new LinkedList<>();

	public MyGeneralTreeNode(T data)
	{
		this.data = data;
	}
        public MyGeneralTreeNode()
        {
            
        }

	public int getHeight()
        {
            if (children.isEmpty())
            {
                return 1;
            }
            int height = children.get(0).getHeight();
            for (int i = 0; i < children.size(); i++)
            {
                if (children.get(i).getHeight() > height)
                {
                    height = children.get(i).getHeight();
                }
            }
            return height + 1;
        }

	public int getNumberOfBranchNodes()
	{
            int nodes = 1;
            if (children.isEmpty() )
            {
                return 0;
            }
            for (MyGeneralTreeNode<T> child : children)
            {
                nodes += child.getNumberOfBranchNodes();
            }
            return nodes;
	}

	public int getNumberOfLeaves()
	{
            int leaves = 0; 
            if (children.isEmpty() )
            {
                return 1;
            }
            for (MyGeneralTreeNode<T> child : children)
            {
                leaves += child.getNumberOfLeaves();
            }
            return leaves;
	}

	public int getNumberOfNodes()
	{
            int nodes = 1;
            if (children.isEmpty() )
            {
                return 1;
            }
            for (MyGeneralTreeNode<T> child : children)
            {
                nodes += child.getNumberOfNodes();
            }
            return nodes;
	}

	public boolean isLeaf()
	{
            return children.isEmpty();
	}
        
        
        
	public String getPostOrderStructure()
        {            
            String output = "";
            if (children == null || children.size() == 0)
            {
                return data.toString();
            }
            
            for (int i = 0; i < children.size(); i++)
            {                               
                output += children.get(i).getPostOrderStructure();
            }
            return output + data.toString();
        }

	public String getPreOrderStructure()
        {
            String output = data.toString();
            if (children == null || children.isEmpty())
            {
                return data.toString();
            }

            for (int i = 0; i < children.size(); i++)            
            {            
                output += children.get(i).getPreOrderStructure();
            }
            return output;
        }

        
	public String getBreadthFirstStructure() /// this should never get called except by the root
	{
            int height = getHeight();
            LinkedList<KeyValuePair<Integer, MyGeneralTreeNode<T>>> queue = new LinkedList<>();
            getBreadthFirstStructure(1, height, queue); //levels are 1 based, just like height
            String output = "";
            
            for (KeyValuePair<Integer, MyGeneralTreeNode<T>> pair : queue)
            {
                output += pair.value.toString();
            }
            return output;
	}
        
        private void getBreadthFirstStructure(int level, int height, LinkedList<KeyValuePair<Integer, MyGeneralTreeNode<T>>> queue)
        {            
           
            if (children.isEmpty())
            {
                return;
            }
            if (level == 1) /// ONLY the root actually adds itself
            {
                KeyValuePair<Integer, MyGeneralTreeNode<T>> pair = new KeyValuePair(1 , this);
                queue.add(pair);                   
            }
            while (level < height)
            {
                KeyValuePair<Integer, MyGeneralTreeNode<T>> pair = new KeyValuePair<>(); 
                int size = queue.size();
                for (int k = 0; k < size; k++)
                {
                    if (queue.get(k).key == level)
                    {                                                                       
                        for (MyGeneralTreeNode child : queue.get(k).value.children)
                        {
                            pair = new KeyValuePair(level + 1, child);
                            queue.add(pair);
                        }                        
                    }                    
                }
                level++;
            }
            
            
            
            
            
            
            
            
//            for (MyGeneralTreeNode child : children) // now pass the queue to the kids to do the same
//            {
//                child.getBreadthFirstStructure(level + 1, height, queue);
//            }              
            
        }

	
        
         public int getNodeCountAtLevel(int level)
        {
            if (level == 0)
            {
                return 1;
            }
            int count = 0;
            for (int i = 0; i < children.size(); i++)
            {
                count += children.get(i).getNodeCountAtLevel(level - 1);
            }
            return count;
        }

//        public String getStructure(int level)
//        {   
//            if (children == null)
//            {
//                return "|-- " + data.toString() + System.lineSeparator();
//            }
//            String output = "";
//            for (int i = 2; i < level; i++)
//            {
//                output += "    ";
//            }
//            output += "|--" + data.toString() + System.lineSeparator();
//            
//            for (int i = 0; i < children.size(); i++)
//            {
//                output += "    " + children.get(i).getStructure(level + 1);
//            }                        
//            return output;                        
//        }

         public String getStructure(int level)
         {
             String output = "";
             for (int i = 1; i < level; i++)
             {
                 output += "    ";
             }
             output += "|-- " + data.toString() + System.lineSeparator();
             for (int k = 0; k < children.size(); k++)
             {
                 output += children.get(k).getStructure(level + 1);
             }
             return output;
         }
         
	@Override 
        public String toString()
	{
		return data.toString();
	}
}
