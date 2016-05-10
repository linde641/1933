/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this temp1late file, choose Tools | Templates
 * and open the temp1late in the editor.
 */

package hw3;

/**
 *
 * @author paidforbyoptions
 */
public class MyReversableLinkedList<T>  implements MyList<T>
{
    DoubleLinkedNode<T> head = null;
    DoubleLinkedNode<T> tail = null;
    int size = 0;
    
    @Override    
    public void add(T item) 
    {
        DoubleLinkedNode<T> addThisNode = new DoubleLinkedNode<>();
        addThisNode.data = item;
        if (head == null)
        {
            head = addThisNode;
            tail = addThisNode;         
            return;
        }
       
        tail.next = addThisNode;
        addThisNode.prev = tail;
        tail = tail.next;                 
    }

    @Override
    public T get(int index)
    {
        if (head == null)
        {
            return null;
        }
        DoubleLinkedNode<T> current = head;
       
        
        for (int i = 0; i < index; i++)
        {
            if (current.next == null)
            {
                return null;
            }
            current = current.next;
        }
       
        return current.data;
    }

    @Override
    public int getSize()
    {
        int size = 0;
        DoubleLinkedNode<T> current = new DoubleLinkedNode<T>();
        current = head;
        
        while (current != null)
        {
            size++;
            if (current.next == null)
            {
                return size;
            }            
            current = current.next;
        }
        return size;
    }

    @Override
    public void clear()
    {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void remove(int index)
    {
        DoubleLinkedNode<T> current = head;        
        for (int i = 0; i < index - 1; i++)
        {
            current = current.next;
        }
        if (index == 0)
        {
            if (head.next == null)
            {
                head = null;
                return;
            }
            head = head.next;
            head.prev = null;
            return;
        }        
        if (current.next != null)
        {
            
            if (current.next.next != null)
            {
                current.next = current.next.next;
                current.next.prev = current;
                return;
            }
            current.next = null;                                
            return;
        }
        current = null; /// only getes here if list is of size 1               
    }
    
    public void reverse()
    {
        DoubleLinkedNode<T> temp = new DoubleLinkedNode<>();
        
        temp = head;
        head = tail;
        tail = temp;
        temp = head;
        DoubleLinkedNode<T> current = head;
   
        while (current != null)
        {             
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;           
       
            current = current.next;
        }
    }
    
    @Override
    public String toString()
    {
        String output = "";
        for (int i = 0; i < getSize(); i++)
        {
            output += get(i).toString() + System.lineSeparator();
        }
        return output;
    }
    

   }

