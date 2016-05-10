package hw4;

/**
 *
 * @author shakil
 */
public interface MyHeap<T extends Comparable>
{
    public T peek();
    public T pop();
    public void push(T data);
    public boolean isEmpty();
    public String getStructure();
}
