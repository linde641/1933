package hw4;

/**
 *
 * @author
 */
public class BinarySearchTree<T extends Comparable>
{
    BinaryTreeNode<T> root;
    
    public BinarySearchTree()
    {
        root = new BinaryTreeNode();
    }
    
	public void add(T item)
	{            
            if (root == null)
            {
                root = new BinaryTreeNode(item);
            }
            if (root.data == null)
            {
                root.data = item;
                return;
            }
            root.add(item);
	}

	public boolean contains(T item)
	{
            return root.contains(item);
	}

	public int getDistance(T item)
	{
            if (!contains(item) )
            {
                return -1;
            }
            return root.getDistance(item);
        }

	public String getStructure()
	{
            return root.getStructure(1);
	}

	@Override
	public String toString()
	{
		return getStructure();
	}
}
