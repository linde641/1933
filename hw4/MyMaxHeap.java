package hw4;

/**
 *
 * @author
 */
class MyMaxHeap<T extends Comparable>
		extends MyFlatBinaryTree<T>
		implements MyHeap<T>
{
	protected int lastNodeIndex = 0;

	//<editor-fold defaultstate="collapsed" desc="Heap interface">
	@Override
	public boolean isEmpty()
	{
            return get(1) == null;
	}

	@Override
	public T peek()
	{
		return get(1);
	}

	@Override
	public T pop()
	{
            T output = get(1);
            set(1, get(lastNodeIndex));
            set(lastNodeIndex, null);
            lastNodeIndex--;
            sink(1);
            return output;            
	}

	@Override
	public void push(T item)
	{            
            if (lastNodeIndex == getCapacity())
            {
                addLevel();
            }                        
            set(lastNodeIndex + 1, item);
            lastNodeIndex++;
            rise(lastNodeIndex);
	}
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="helper methods">
	private void rise(int currentIndex)
	{
            if (getParentIndex(currentIndex) == 0)///calling rise on root means node has risen to the top and should stop
            {
                return;///rose to the top;
            }
            if (isBigger(get(getParentIndex(currentIndex)), get(currentIndex)))//found the right place
            {
                return;
            }
            swap(getParentIndex(currentIndex), currentIndex);
            rise(getParentIndex(currentIndex));///because the data was swapped already;            
	}

	private void sink(int currentIndex)
	{
            if (isEmpty())
            {
                return;
            }
            if (isLeaf(currentIndex))// can't sink any further
            {
                return;
            }
            if (isBigger(get(currentIndex), get(getIndexOfBiggestChild(currentIndex))))
            {
                return;
            }            
            int indexOfBiggestChild = getIndexOfBiggestChild(currentIndex);
            swap(currentIndex, indexOfBiggestChild);
            sink(indexOfBiggestChild);
	}

	private int getIndexOfBiggestChild(int currentIndex)
	{
            int left = 2*currentIndex;
            int right = 2*currentIndex + 1;
            T leftObject = get(left);
            T rightObject = get(right);
            if (rightObject == null)//handles the situation where right child is null so there isn't an NPE
            {
                return left;
            }
            if (leftObject.compareTo(rightObject) >= 0)
            {
                return left;
            }
            return right;
	}

	private boolean isBigger(T a, T b)//or equal
	{
            if (a == null && b != null)
            {
                return false;
            }
            if (a != null && b == null)
            {
                return true;
            }
		return a.compareTo(b) >= 0;
	}

	private void swap(int a, int b)
	{
            T temp = get(a);
            set(a, get(b));
            set(b, temp);
	}
      
	//</editor-fold>

	@Override
	public String toString()
	{
		return this.getStructure();
	}
        
        public String getStructure()
        {
            String output = "";
            for (int i = 1; i <= lastNodeIndex; i++)
            {
                String element = get(i).toString();
                output += element + " ";
            }
            return output.trim();
        }
}
