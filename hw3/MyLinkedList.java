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
public class MyLinkedList<T> implements MyList<T>
{
    public int size = 0;
    
    public ListNode<T> head = null;
    public ListNode<T> tail;
    
    public MyLinkedList()
    {
        head = null;
        tail = null;
    }
    
    public MyLinkedList(T[] items)
    {
        ListNode<T> current = head;
        head.data = items[0];
        
        
        for (int i = 1; i < items.length; i++)
        {
            ListNode<T> newNode = new ListNode<>();
            newNode.data = items[i];
            current.next = newNode;
            tail = current;
        }
    }
    
    
    
    @Override
    public void add(T item)
    {
        
        ListNode<T> addThisNode = new ListNode();
        addThisNode.data = item;
        if (head == null)
        {
            head = addThisNode;
            tail = addThisNode;
            size++;            
            return;
        }
       
        tail.next = addThisNode;
        tail = tail.next;                 
        size++;
    }
    
    public void addAll(T[] items)
    {
        for (int i = 0; i < items.length; i++)
        {
            add(items[i]);
        }
    }
    
    
    public boolean contains(T item)
    {
        for (int i = 0; i < getSize(); i++)
        {
            if (get(i) == item)
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public T get(int index)
    {
        if (head == null)
        {
            return null;
        }
        ListNode<T> current = head;
       
        
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
    
    public T pop()
    {
        if (head == null)
        {
            return null;
        }
        
        T output = get(0);
        head = head.next;
        size = size - 1;
        return output;
    }
    
    public void push(T item)
    {
        add(item);
    }
    
    @Override
    public int getSize()
    {
        int size = 0;
        ListNode<T> current = new ListNode<>();
        current = head;
        
        while (current != null)
        {
            size++;
            if (current.next == null)
            {
                return size;
            }
            
            //System.out.println(size);
            current = current.next;
        }
        return size;
    }
    
    @Override
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void insert(int index, T item)
    {
        ListNode<T> current = head;
        ListNode<T> newNode = new ListNode<>();
        newNode.data = item;
        
        if (index == 0)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        for (int i = 0; i < index - 1; i++)
        {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        
    }
    
    public void remove(int index)
    {
        int size = getSize();
        ListNode<T> current = head;
        if (index == 0)
        {
            head = head.next;
            return;
        }
        
        
        for (int i = 0; i < index-1; i++)
        {
            current = current.next;
        }
//        if (index == size - 1)
//        {
//            current.next = null;
//            return;
//        }
        current.next = current.next.next;
    }
    
    public void removeRange(int start, int end)//start and end are zero based indices
    {
        ListNode<T> current1 = head;
        ListNode<T> current2; 
        int size = getSize();
        for (int i = 0; i < start - 1 ; i++)
        {
            current1 = current1.next;
        }
        current2 = current1;
        for (int j = 0; j <= end - start; j++)
        {
            current2 = current2.next;
        }
        if (start == 0)
        {
            head = current2;
            return;
        }
        if (end == size - 1)
        {
            current1.next = null;
            return;
        }
        current1.next = current2.next; //deletes current1.next and current2
    }
    
//    public void removeRange2(int start,int end)
//    {
//        ListNode<T> starter = head;
//        ListNode<T> current = head;
//        int i = 0;
//        while (i != start)
//        {
//            current = current.next;
//            starter = current;
//        }
//        
//    }
    
    public void update(int index, T item)
    {
        ListNode<T> current = head;
        
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        
        current.data = item;
    }
    
}