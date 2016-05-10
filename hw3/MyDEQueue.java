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
public class MyDEQueue<T> extends MyLinkedList<T>

        
{
    //ListNode<T> head = null;
    
    @Override
    public T pop()
    {
        if (head == null)
        {
            return null;
        }
        
        ListNode<T> pointer = head;
        head = head.next;
        return pointer.data;
    }
    
    public void pushToFront(T item)
    {
        if (head == null)
        {
            add(item);
            return;
        }
        
        ListNode<T> newNode = new ListNode<>();
        newNode.data = item;
        newNode.next = head;
        head = newNode;
        
    }
    
    public void pushToBack(T item)
    {
        add(item);
    }
    
    public T peek()
    {
        return head.data;
    }
    

    
    public boolean isEmpty()
    {
        return head == null;
    }
    
}
