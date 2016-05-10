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
public class DestructiveList<T> extends MyLinkedList<T>
{
    
    public void removeEvery(int number)
    {
        ListNode<T> current = head;
        int count = 0;
        int i = 1;
        if (number == 1)
        {
            int size = getSize();
            head = null;
            return;
            //return size;
        }
        
        while (current != null)
        {
            if ( (i+1) % number == 0)
            {
                if (current.next == null)
                {     
                    return;
                    //return count;
                }
                
                current.next = current.next.next;
                count++;
                i++;
                
            }
            i++;
            current = current.next;
        }        
        return;        
        //return count;
    }
    
    
    
    public void removeEvery(int number, int startingIndex)
    {       
        ListNode<T> current = head;
        int count = 0;
        int i;
        for (i = 0; i < startingIndex - 1; i++)///gets current to the correct starting index
        {            
            current = current.next;
        }
        //current is now at the node before the index passed in
        if (number == 1)//specific case for an argument of 1
        {
//            int size = getSize();
            current.next = null;            
//            current.data = null;
//            current = null;
            //remove(getSize() - 1);
            
            
            
            return;
            //return size - i + 1 ; // number of elem
        }
        
        while (current != null) //number != 1
        {
            if ( (i + 1) % number == 0)
            {
                if (current.next == null)
                {     
                    return;
                    //return count;
                }
                
                current.next = current.next.next;
                count++;
                i++;
                
            }
            i++;
            current = current.next;
        } 
        return;
        //return count;
    }            
    
    public int removeGroupsOf(int groupSize)
    {
        ListNode<T> current = head;
        ListNode<T> starter = head;
        int counter = 1;
        int output = 0;
        int binary = 0;
        
        if (groupSize == 1)
        {
            head = null;
            output = getSize();
        }
        
        while(current != null)
        {
            if (current.next == null) ///this inlet avoids null pointer once we are in the final group
            {                //obviously this is the end of a group;
                if (counter >= groupSize)
                {
                    if (starter == head)
                    {
                        if (head.data.toString().equals(head.next.data.toString())) //deleting first group;
                        {
                            head = current.next;
                            starter = head;
                            output++;
                            counter = 1;     
                            
                        }
                        else /// specific case of needing to save the head but delete second group
                        {
                            head.next = current.next;
                            starter = head;
                            output++;
                            counter = 1;
                        }
                    }
                    else //// deleting group but starter is not at head; most likely case
                    {
                        starter.next = current.next;
                        counter = 1;
                        output++;
                    }
                }
                return output;
            }
            
            
            
            
            if (current.data.toString().equals(current.next.data.toString()))
            {
                counter++;                
            }
            else /// current is at the end of a group
            {
                if (counter >= groupSize)//if the group is large enough to be deleted
                {
                    if (starter == head)
                    {
                        if (head.data.toString().equals(head.next.data.toString())) //deleting first group;
                        {
                            if (binary != 1) // we have nesting in first group
                            {
                                head = current.next;
                                starter = head;
                                output++;
                                counter = 1;                                   
                            }
                            else
                            {
                                head.next = current.next;
                                starter = head;
                                output++;
                                counter = 1;
                                binary = 0;
                            }
                        }
                        else /// specific case of needing to save the head but delete second group
                        {
                            if (starter.data.toString().equals(current.next.data.toString()))//nesting issues may arise
                            {
                                binary = 1;
                            }
                            head.next = current.next;
                            starter = head;
                            output++;
                            counter = 1;
                        }
                    }
                    else //// deleting group but starter is not at head; most likely case
                    {
                        starter.next = current.next;
                        counter = 1;
                        output++;
                    }
                    
                }
                else //group is too small to delete
                {
                    starter = current;
                    counter = 1;
                }
                
            }
            
            
            current = current.next;
            
            
        }
        return output;
            
    }
    protected NodeGroup getGroup(ListNode start, int count)
	{
		NodeGroup group = new NodeGroup();
		group.start = start;
		group.end   = start;
		group.count = 1;
		while (group.count < count && group.end.next != null)
		{
			group.count++;
			group.end = group.end.next;
		}
		return group;
	}
    
    
    
    
    
    public int persistentlyRemoveGroupsOf(int size)
    {        
        int removed = removeGroupsOf(size);
        int finalOutput = removed;
        
        while (removed != 0)
        {            
            removed = removeGroupsOf(size);
            finalOutput += removed;
        }
        
        return finalOutput;
        
    }
    
//    public void rotateHelper(ListNode<T> start, int size)
//    {//front should become end ,second becomes first, etc;
//        ListNode<T> tail = 
//        for (int i = 0; i < size; i++)
//        {
//            
//        }
//    }
    
    public void rotate(int groupSize)
    {
        ListNode<T> current = head;
        ListNode<T> starter = head;
        ListNode<T> end = head;
        ListNode<T> temp = new ListNode<>();
        int counter = 1; 
        
        
        
        while (current != null)
        {            
            if (counter == groupSize) // so current will be at the end of the subset
            {
                if (starter == head)
                {
                    end = current;
                    current = current.next;
                    temp = head;                    
                    head = head.next;                     
                    temp.next = current;
                    end.next = temp;
                    starter = temp;
                    
                    
                    counter = 1;
                    continue;
                }
               
                if (starter != head)
                {
                    end = current;                    
                    current = current.next;
                    temp = starter.next;
                    starter.next = starter.next.next;                   
                    temp.next = current;
                    end.next = temp;
                    starter = temp;
                    counter = 1;
                }
                
                starter = temp;                
                
                
                continue;
            }
            
            else
            {
                current = current.next;
                counter++;
            }
            
        }
    }    
}
