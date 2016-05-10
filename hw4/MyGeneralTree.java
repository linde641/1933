package hw4;

public class MyGeneralTree<T>
{
	MyGeneralTreeNode<T> root;

	public MyGeneralTree(T data)
	{
		this.root = new MyGeneralTreeNode<>(data);
	}

	public MyGeneralTree(MyGeneralTreeNode<T> root)
	{
		this.root = root;
	}

	public int getHeight()
	{
		return root.getHeight();
	}

	public int getNodeCountAtLevel(int level)
	{
            return root.getNodeCountAtLevel(level);
	}

	public int getNumberOfBranchNodes()
	{
            return root.getNumberOfBranchNodes();
	}

	public int getNumberOfLeaves()
	{
            return root.getNumberOfLeaves();
	}

	public int getNumberOfNodes()
	{
            return root.getNumberOfNodes();
	}

	String getPostOrderStructure()
	{
            return root.getPostOrderStructure();
	}

	String getPreOrderStructure()
	{
            return root.getPreOrderStructure();
	}

	String getBreadthFirstStructure()
	{
            return root.getBreadthFirstStructure();
	}

	public String getStructure()
	{
            return root.getStructure(1);
	}
}
