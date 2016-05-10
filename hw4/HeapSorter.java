package hw4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author
 * @param <T>
 */
public class HeapSorter<T extends Comparable>
{
	public List<Comparable> sortDescending(List<T> objectsToSort)
	{
		MyHeap heap = new MyMaxHeap();
                List<Comparable> output = new LinkedList<>();
                int size = objectsToSort.size();
		for (int i = 0; i < size; i++)
                {
                    heap.push(objectsToSort.get(i));
                }
                for (int k = 0; k < size; k++)
                {
                    Comparable object = heap.pop();
                    output.add(object);
                }
                return output;
	}
        
        public List<Comparable> sortAscending(List<T> objectsToSort)
        {
            MyHeap heap = new MyMinHeap();
            List<Comparable> output = new LinkedList<>();
            int size = objectsToSort.size();
            for (int i = 0; i < size; i++)
            {
                heap.push(objectsToSort.get(i));
            }
            for (int k = 0; k < size; k++)
            {
                output.add(heap.pop());
            }
            return output;
        }
}
