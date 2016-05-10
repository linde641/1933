package hw4;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author
 */
public class MyHashTable<K, V>
{
    float loadFactor;
    List<KeyValuePair<K,V>>[] buckets; 
    int size;
	//<editor-fold defaultstate="collapsed" desc="initialize">
    
	public MyHashTable(int initialCapacity, float loadFactor)
	{
		this.loadFactor = loadFactor;
		buckets = createBucketList(initialCapacity);
	}
        
 
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="public API">    
	public boolean contains(K key)
        {
            List<KeyValuePair<K,V>> list = new LinkedList<>();
            for (int i = 0; i < buckets.length; i++)
            {
                list = buckets[i];
                for (int j = 0; j < list.size(); j++)
                {
                    if (list.get(j).key.equals(key))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

	

	public int getBucketIndex(K key)
	{            
            int index = key.hashCode() % buckets.length;
            if (index < 0)
            {
                index = Math.abs(key.hashCode() % buckets.length);
            }
            return index;
	}

	public int getCapacity()
	{            
            return buckets.length;
	}

	public List<K> getKeys()
	{
            List<K> keys = new LinkedList<>();
            for (int i = 0; i < buckets.length; i++)
            {
                for (int j = 0; j < buckets[i].size(); j++)
                {
                    keys.add(buckets[i].get(j).key);
                }
            }
            return keys;
	}

        public int getSize()
        {
            int size = 0;;
            for (int i = 0; i < buckets.length; i++)
            {
                size += buckets[i].size();
            }
            return size;
        }

        public V get(K key)                
	{
            List<KeyValuePair<K,V>> list = buckets[getBucketIndex(key)];
            for (int i = 0; i < list.size(); i++)
            {
                if (list.get(i).key.equals(key))
                {
                    return list.get(i).value;
                }
            }
            return null;
	}
        
         public void put(K key, V value)
         {        
            KeyValuePair pair = new KeyValuePair(key, value);            
            int bucketsUsed = numberOfBucketsUsed();
            int index = getBucketIndex(key);

            if (contains(key))//// deletes the old value and adds this new one
            {
                List<KeyValuePair<K,V>> list = buckets[getBucketIndex(key)];
                for (int i = 0; i < list.size(); i++)
                {
                    if (list.get(i).key.equals(key))
                    {
                        list.get(i).value = value;
                        return;
                    }
                }
            }
            
           // if (bucketsUsed >= buckets.length*loadFactor)
            if (getSize() >= buckets.length*loadFactor)
            {                
                buckets = grow(buckets.length);
                index = getBucketIndex(key) ;
              //  System.out.println("just grew : " + index);
            }
             //System.out.println("index not inside =" + index);
            buckets[index].add(pair);
        }
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="internal methods">
	/**
	 * This is seriously ugly. i'm just going to give it to you.
	 * The code works once you create the classes and variables it asks for.
	 * @param capacity Capacity we want the bucket list to have
	 * @return
	 */
	private List<KeyValuePair<K, V>>[] createBucketList(int capacity)
	{
		//--- Creating arrays of templated objects has nasty syntax in java
		//--- Could also be unsafe and create an array of List<Object>
		Class<?> type = new LinkedList<KeyValuePair<K, V>>().getClass();
		List<KeyValuePair<K, V>>[] newBuckets =
				(List<KeyValuePair<K, V>>[]) Array.newInstance(type, capacity);

		//--- Put a list in each array spot
		for (int i = 0; i < newBuckets.length; i++)
		{
			newBuckets[i] = new LinkedList<>();
		}

		//--- Reset the size
		size = 0;

		return newBuckets;
	}

        protected int numberOfBucketsUsed()
        {
            int bucketsUsed = 0;
            for (int i = 0; i < buckets.length; i++)
            {
                if (!buckets[i].isEmpty())
                {
                    bucketsUsed++;
                }            
            }
            return bucketsUsed;
        }
        
	private List<KeyValuePair<K,V>>[] grow(int length)
        {
            int newLength = getNextPrime(length);
            List<KeyValuePair<K,V>>[] newData = createBucketList(newLength);
            List<KeyValuePair<K,V>> newList = new LinkedList<>();

            for (int i = 0; i < buckets.length; i++)
            {
                for (int j = 0; j < buckets[i].size(); j++)
                {
                    KeyValuePair<K,V> pair = buckets[i].get(j);
                    int index = Math.abs(pair.key.hashCode()) % newData.length;
                    newData[index].add(pair);
                }            
            }
            return newData;
        }
              protected int getNextPrime(int value)
       {
           for (int i = (value + 1);; i++)
           {
               if (isPrime(i))
               {
                   return i;
               }
           }
       }

    protected boolean isPrime(int number)
    {
        double largestPossibleFactor = Math.sqrt(number);
        for (int i = 2; i <= largestPossibleFactor; i++)
        {
            if ((number % i) == 0)
            {
                return false;
            }
        }

        return true;
    }

//	private List<KeyValuePair<K, V>> getBucket(K key)
//	{
//            
//	}
//
//	private KeyValuePair<K, V> getKeyValuePair(K key)
//	{
//	}
//
//	private KeyValuePair<K, V> getKeyValuePair(K key, List<KeyValuePair<K, V>> bucket)
//	{
//	}
//
//	private int getPositionInBucket(K key, List<KeyValuePair<K, V>> list)
//	{
//	}
//
//	private void resize()
//	{
//		List<KeyValuePair<K, V>>[] oldBuckets = buckets;
//		int newCapacity = MyMath.getNextPrime(buckets.length);
//	}
	//</editor-fold>
}
