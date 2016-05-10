/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw3;

/**
 *
 * @author paidforbyoptions
 * @param <T>
 */
public class MyBiasedQueue<T> extends MyLinkedList<T>
{
    String nameOfThingWeHate;
   
    
    public MyBiasedQueue(String nameOfThingWeHate)
    {
        this.nameOfThingWeHate = nameOfThingWeHate;
    }
    
   
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    @Override
    public void push(T item)
    {
        ListNode<T> temp = new ListNode<>();
        
        if(item.toString().equals(nameOfThingWeHate))
        {            
            add(item);
           // System.out.println("item was equal to nameofthingwehate");
            return;
        }
        
        if(tail == null)
        {
            add(item);
            return;
        }
        if (head.data.toString().equals(nameOfThingWeHate))
        {//if thing we hate is added first, add second thing and flip the order
            temp = head;
            head = null;            
            add(item);
            add(temp.data);                                  
            return;
        }
        if(tail.data.toString().equals(nameOfThingWeHate)) // checks if list contains thingwehate
        {            
            ListNode<T> current = head;
            temp = tail; //or could say temp = current.next
            
            while (!current.next.data.toString().equals(nameOfThingWeHate) )
            {
                current = current.next;//current should always be the node before tail;
            }
            
            
            ListNode<T> newNode = new ListNode<>();
            newNode.data = item;
            newNode.next = current.next;
            current.next = newNode;
            return;
            
        }
        add(item);
        
    }
    
    public T peek()
    {
        if (head == null)
        {
            return null;
        }
        return (T) head.data;
    }
    
    
    
    
}
