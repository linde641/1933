/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw4;

/**
 *
 * @author paidforbyoptions
 */
public class BinaryTreeNode<T extends Comparable> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    
    public BinaryTreeNode(T data)
    {
        this.data = data;
    }
    public BinaryTreeNode()
    {
        this.data = null;
    }
    
//    public void add(T item)
//    {        
//        boolean largerThanHead = item.compareTo(data) > 0;
//        if (largerThanHead)
//        {
//            if (right == null)
//            {
//                right = new BinaryTreeNode(item);
//                return;
//            }
//            else
//            {
//                right.add(item);            
//            }
//        }
//        else // item is smaller than head
//        {
//            if (left == null)
//            {
//                left = new BinaryTreeNode(item);
//                return;
//            }
//            else
//            {
//                left.add(item);
//            }                        
//        }
//         
//    }
       public void add(T item)
{
            if(item.compareTo(data) < 0)
            {
                if(left == null)
                {
                    BinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
                    left = newNode;
                    newNode.data = item;
                    return;
                }
                
              left.add(item);

            }
            
            else
            {
                if(right == null)
                {
                    BinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
                    right = newNode;
                    newNode.data = item;
                    return;
                }
               
              right.add(item);
               
            }
}

//    public boolean contains(T item)
//    {
//        if (data.equals(item) )
//        {
//            return true;
//        }
//        boolean largerThanHead = item.compareTo(data) > 0;        
//        if (largerThanHead)
//        {
//            if (right == null)
//            {
//                return false;
//            }
//            return right.contains(item);
//        }
//        else /// if its not larger than the head;
//        {
//            if (left == null)
//            {
//                return false;
//            }
//            return left.contains(item);
//        }
//    }
    
    
    public boolean contains(T item)
    {
        if (data.equals(item))
        {
            return true;
        }
        if (left == null)
        {            
            if (right == null)
            {
                return false;
            }
            return right.contains(item);
        }
        if (right == null)
        {
            return left.contains(item);
        }
        return left.contains(item) || right.contains(item);
        
    }
        
        

    
    
    public int getDistance(T item)
    {
        return getDistanceHelper(item, 1);
    }

    private int getDistanceHelper(T item, int distance)
    {                
        if (data.equals(item) )
        {
            return distance;
        }
        if (item.compareTo(data) > 0)
        {
            return right.getDistanceHelper(item, distance + 1);
        }
        return left.getDistanceHelper(item, distance + 1);        
    }

        public String getStructure(int level)
        {
            String output = "";
            for (int i = 1; i < level; i++)
            {
                output += "    ";
            }
            output += "|-- " + data.toString() + System.lineSeparator();
            
            if (left != null)
            {
                output += left.getStructure(level + 1);
            }
            if (right != null)
            {
                output += right.getStructure(level + 1);
            }
            return output;
        }
   
    
}
