package hw4;

/**
 *
 * @author
 */
public class HeapChecker<T extends Comparable>
{
//	public boolean isAMaxHeap(MyFlatBinaryTree<T> possibleHeap)
//	{
//            if (possibleHeap.isLeaf(1))
//            {
//                return true;
//            }
//            T parent = possibleHeap.get(1);
//            T left = possibleHeap.get(possibleHeap.IndexOfLeftChild(1));
//            T right = possibleHeap.get(possibleHeap.IndexOfRightChild(1));
//            if (parent.compareTo(left) >= 0 && parent.compareTo(right) >= 0)//still a heap at this point
//            {
//                return isAMaxHeap()
//            }
//            
//	}
//       
        public boolean isAMaxHeap(MyFlatBinaryTree<T> possibleHeap)
        {
            return isAMaxHeap(possibleHeap, 1);
        }
        private boolean isAMaxHeap(MyFlatBinaryTree<T> possibleHeap, int currentIndex)
        {
            int lastOccupiedIndex = possibleHeap.lastOccupiedIndex();
            for (int k = 1; k <= lastOccupiedIndex; k++)
            {
                if (possibleHeap.get(k) == null)
                {
                    return false;
                }
            }
            if (possibleHeap.isLeaf(currentIndex))
            {
                return true;
            }
            T parent = possibleHeap.get(currentIndex);
            T leftChild = possibleHeap.get(possibleHeap.IndexOfLeftChild(currentIndex));
            T rightChild = possibleHeap.get(possibleHeap.IndexOfRightChild(currentIndex));
            if (rightChild == null)//only has a left child, since we know its not a leaf if it got here
            {
                if (parent.compareTo(leftChild) >= 0)///its still a heap as far as this node is concerned, so check if both kids are
                {
                    return (isAMaxHeap(possibleHeap, possibleHeap.IndexOfLeftChild(currentIndex)));
                           
                }
            }
            if (parent.compareTo(leftChild) >= 0 && parent.compareTo(rightChild) >= 0)//has two children
            {
                return (isAMaxHeap(possibleHeap, possibleHeap.IndexOfLeftChild(currentIndex)) && 
                            isAMaxHeap(possibleHeap, possibleHeap.IndexOfRightChild(currentIndex)));
            }
            return false;
        }

        public boolean isAMinHeap(MyFlatBinaryTree<T> possibleHeap)
        {
            return isAMinHeap(possibleHeap, 1);
        }
	private boolean isAMinHeap(MyFlatBinaryTree<T>  possibleHeap, int currentIndex)
	{
            int lastOccupiedIndex = possibleHeap.lastOccupiedIndex();
            for (int k = 1; k <= lastOccupiedIndex; k++)
            {
                if (possibleHeap.get(k) == null)
                {
                    return false;
                }
            }
            ///if it gets here, there are no gaps in the array
            if (possibleHeap.isLeaf(currentIndex))
            {
                return true;
            }
            T parent = possibleHeap.get(currentIndex);
            T leftChild = possibleHeap.get(possibleHeap.IndexOfLeftChild(currentIndex));
            T rightChild = possibleHeap.get(possibleHeap.IndexOfRightChild(currentIndex));
            if (rightChild == null)//only has a left child, since we know its not a leaf if it got here
            {
                if (parent.compareTo(leftChild) <= 0)
                {
                    return (isAMinHeap(possibleHeap, possibleHeap.IndexOfLeftChild(currentIndex)));
                            
                }
            }
            if (parent.compareTo(leftChild) <= 0 && parent.compareTo(rightChild) <= 0)//has two children
            {
                return (isAMinHeap(possibleHeap, possibleHeap.IndexOfLeftChild(currentIndex)) && 
                            isAMinHeap(possibleHeap, possibleHeap.IndexOfRightChild(currentIndex)));
            }
            return false;
	}
}
