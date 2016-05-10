package hw3;

import hw3.MyList;


public class MyArrayList<T>
	implements MyList<T>
{
    
    
    T[] data;
    int size= 0;
    
    public MyArrayList(int initialCapacity) // constructor for a given size
    {
        data = getArrayOfSize(initialCapacity);
    }
    
    public MyArrayList() // null constructor
    {        
        data = getArrayOfSize(10);
    }
    
    public MyArrayList(T[] items)
    {        
        data = getArrayOfSize(2*items.length);
        int index = 0;
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                data[index] = items[i];
                index++;
            }      
        }
    }
            
       public void grow()
        {
        T[] temp = getArrayOfSize(2*data.length);
        
        for (int i = 0; i < getSize(); i++)
        {
            temp[i] = data[i];
        }
        data = temp;
        }
    
    @Override
    public void add(T item)
    {
        int size = getSize();
        if (getSize() == data.length -1)
        {
            grow();
        }
            data[size] = item;
            size++;
        
    }
    
    public void addAll(T[] items)
    {
        
        for (int i = 0; i < items.length; i++)
        {
            add(items[i]);
        }
    }
    
     @Override
    public void clear()
    {
        for (int i = 0; i < data.length; i++)
        {
            data[i] = null;
        }
    }
    
    @Override
    public T get(int index)
    {
        return data[index];
    }
    
   
    @Override
    public int getSize()
    {
        int size = 0;
        int i = 0;
        while (data[i] != null)
        {
            size++;
            i++;
        }
        return size;
       
    }
    
    public boolean contains(T item)
    {
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == item)
            {
                return true;
            }
        }
        
        return false;
    }
    
    public void insert(int index, T item)
    {
        if (getSize() == data.length - 1)
        {
            grow();
        }
        if (index >= getSize())
        {
            add(item);
            return;
        }
        
        for (int i = getSize() - 1; i >= index; i = i - 1)
        {
            data[i+1] = data[i];
        }
        
        data[index] = item;
    }
    
    public void remove(int index)
    {
        for (int i = index; i < getSize(); i++)
        {
            data[i] = data[i+1];
        }
        
    }
    
    public void removeRange(int start, int end)
    {
        int counter = 1;
        int size = getSize();
        if (size >= data.length/2)
        {
            grow();
        }
        for (int i = start; i <= size; i++)
        {            
            data[i] = data[end + counter];
            data[end + counter] = null;
            counter++;
        }
    }
    
    public void update(int index, T item)
    {
        data[index] = item;
    }

 /**
	 * Java doesn't make it easy to dynamically create arrays of generics
	 * so we'll just give you the code for this.
	 * @param capacity
	 * @return
	 */
	private T[] getArrayOfSize(int capacity)
	{
		T[] newSpace = (T[]) new Object[capacity];
		return newSpace;
	}
	//</editor-fold>
}