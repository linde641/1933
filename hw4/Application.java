/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw4;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author paidforbyoptions
 */
public class Application 
{
     public static void main(String[] args)
    {
        
        Application app = new Application();
        //app.anagramTest();
        //System.out.println(app.NodetreeTest() );
        //System.out.println(app.ArrayTreeTest() );
        //app.ArrayTreeTest();
        //app.BinarySearchTest();
        //app.mapTest();
        //app.generalTreeTest();
        //app.HeapTest();
        app.HeapVerifierTest();
    }
    
    public void mapTest()
    {
        MyHashTable<String, Integer> map = new MyHashTable<>(5, 3);
        map.put("Alice", 95);
        System.out.println("Alice's hashcode is: " + "Alice".hashCode());
        System.out.println("alice's bucket id is: " + map.getBucketIndex("Alice")) ;
        map.put("Bob", 78);
        System.out.println("Bob's Hashcode is: " + "Bob".hashCode());
        System.out.println("bob's bucket id is: " + map.getBucketIndex("Bob"));
        map.put("Carol", 32);
        System.out.println("carol's haschode is: " + "Carol".hashCode());
        System.out.println("carol's bucket id is: " + map.getBucketIndex("Carol"));
        map.put("Dani", 84);
        System.out.println("Dani's hashcode is: " + "Dani".hashCode());
        System.out.println("Dani's bucket id is: " + map.getBucketIndex("Dani"));
        map.put("Scooby Doo Loves You", 15);
        System.out.println("Scooby doo's hashcode is: " + "Scooby Doo Loves You".hashCode());
        System.out.println("scooby doo's bucket id is: " + map.getBucketIndex("Scooby Doo Loves You"));
        System.out.println("K now the size is: " + map.getSize());
        System.out.println("Capacity is: " + map.getCapacity());
        System.out.println("Ok now after adding 5, the keyset is: " + map.getKeys());
        System.out.println("Since the keys are case sensitive, contains(Alice) is: " + map.contains("Alice"));
        System.out.println("contains(alice) is: " + map.contains("alice"));
        System.out.println("get(Alice) should be 95 and returns: " + map.get("Alice"));
        System.out.println("get(Bob) should be 78 and returns: " + map.get("Bob"));
        map.put("aaaaa", 6);
        map.put("bbb", 7);
        map.put("cccccc" , 8);
        map.put("dddddd", 9);
        map.put("eeeeee", 10);
        map.put("ffffff", 11);
        map.put("ggggg", 12);
        map.put("hhhhhh", 13);
        map.put("jjjjjj", 14);
        System.out.println("now after adding some stuff so theres 14 things:");
        System.out.println("size is: " + map.getSize());
        System.out.println("capacity is: " + map.getCapacity());
        map.put("zzzzzz", 15);
        map.put("asfasf", 16);
        System.out.println("added 1 more (15 things)");
        System.out.println("size is: " + map.getSize());
        System.out.println("capacity is: " + map.getCapacity());
        System.out.println("alice bucket id: " + map.getBucketIndex("Alice"));
        System.out.println("bob bucket id: " + map.getBucketIndex("Bob"));
        System.out.println("carol bucket id: " + map.getBucketIndex("Carol"));
        System.out.println("dani bucket id: " + map.getBucketIndex("Dani"));
        System.out.println("scooby  bucket id: " + map.getBucketIndex("Scooby Doo Loves You"));
        
    }
     
    public void anagramTest()
    {
        AnagramChecker checker = new AnagramChecker();
        //System.out.println(checker.areAnagrams("Doctor who & torchwood","doctor who & torchwoody"));
        List<String> list = new LinkedList<>();
        list.add("ABC");
        list.add("cab");
        list.add("a b C");
        list.add("A-B?C");
        list.add("ABBC");
        list.add("DOG");
        //System.out.println(checker.areAnagrams("clint Eastwood", "Old West Action"));
        System.out.println(checker.getAnagrams("ABC", list));
    }
    
    public void generalTreeTest()
    {
        MyGeneralTree<String> tree = new MyGeneralTree<>("A");
        tree.root.children.add(new MyGeneralTreeNode("B"));
        tree.root.children.add(new MyGeneralTreeNode("C"));
        tree.root.children.add(new MyGeneralTreeNode("D"));
        tree.root.children.get(0).children.add(new MyGeneralTreeNode("E"));
        tree.root.children.get(0).children.add(new MyGeneralTreeNode("F"));
        tree.root.children.get(0).children.get(1).children.add(new MyGeneralTreeNode("G"));
        System.out.println("height should be 4 and is: " + tree.getHeight());
        System.out.println("node count at level 3 should be 1 and is: " + tree.getNodeCountAtLevel(3));
        System.out.println("node count at level 1 should be 3 and is: " + tree.getNodeCountAtLevel(1));
        System.out.println("getnumberofbranchnodes should be 3 and is: " + tree.getNumberOfBranchNodes());
        System.out.println("getNumberOfLeaves should be 4 and is: " + tree.getNumberOfLeaves());
        System.out.println("getNumberOfNodes should be 7 and is: " + tree.getNumberOfNodes());
        System.out.println("postOrderStructure: " + tree.getPostOrderStructure());
        System.out.println("preOrderStructure: " + tree.getPreOrderStructure());
        System.out.println("breadthFirstStructure: " + tree.getBreadthFirstStructure());
        System.out.println("getStructure: " + System.lineSeparator() + tree.getStructure());
    }
    
    public String NodetreeTest()
    {
        MyGeneralTree tree = getTree();
        return tree.getStructure();
    }
    
    public void ArrayTreeTest()
    {
        //MyFlatBinaryTree tree = getFullTree();
        
        
        MyFlatBinaryTree<String> tree = getFlatTree();
        //System.out.println("getCapacity: " + tree.getCapacity());
        tree.addLevel();
        tree.addLevel();
        tree.addLevel();
        tree.addLevel();
        tree.addLevel();
        tree.addLevel();
        tree.addLevel();
        tree.set(1, "A");
        tree.set(2,"B");
        tree.set(3, "C");
        tree.set(5, "E");
        tree.set(6, "F");
        tree.set(7, "G");
        tree.set(10, "J");
        tree.set(14, "N");
        System.out.println("height is: " + tree.getHeight());
        System.out.println("number of nodes is: " + tree.getNumberOfNodes());
        System.out.println("number of branches is: " + tree.getNumberOfBranchNodes());
        System.out.println("number of leaves is: " + tree.getNumberOfLeaves());
        System.out.println("preOrderStructure:" + System.lineSeparator() + tree.getPreOrderStructure());
        System.out.println("postOrderStructure:" + System.lineSeparator() + tree.getPostOrderStructure());
        System.out.println(tree.getStructure() );
        System.out.println("NodeCount at level1: " + tree.getNodeCountAtLevel(1));
        System.out.println("NodeCount at level2: " + tree.getNodeCountAtLevel(2));
        System.out.println("NodeCount at level3: " + tree.getNodeCountAtLevel(3));
        System.out.println("NodeCount at level4: " + tree.getNodeCountAtLevel(4));
        //System.out.println(tree.getPreOrderStructure());
        //System.out.println(tree.getNumberOfLeaves());
        //System.out.println(tree.isLeaf(7) );
    }
    
    public void HeapTest()
    {
        MyMaxHeap heap = getMaxHeap();
        System.out.println("heap structure: " + heap.getStructure());
    }
    public MyMaxHeap<Integer> getMaxHeap()
    {
        MyMaxHeap<Integer> heap = new MyMaxHeap<>();
        heap.push(51);
        heap.push(22);
        heap.push(72);
        heap.push(83);
        heap.push(63);
        heap.push(33);
        heap.push(53);
        heap.push(74);
        heap.push(14);
        heap.push(94);
        return heap;
        
        
        
    }
    public MyMaxHeap<Integer> getBadMaxHeap()
    {
        MyMaxHeap<Integer> heap = new MyMaxHeap<>();
        heap.push(51);
        //heap.push(22);
        //heap.push(72);
        
        
        heap.set(1, 17);
        
        
        
        
      
        //heap.set(9, null);
        MyMaxHeap<Integer> nigger = new MyMaxHeap<>();
        //nigger = heap;
        return heap;
    }
    
    public void HeapVerifierTest()
    {
        MyMaxHeap<Integer> heap = getBadMaxHeap();
        
        
        HeapChecker checker = new HeapChecker();
        System.out.println(checker.isAMaxHeap(heap));
        System.out.println(checker.isAMinHeap(heap));
    }
   
    
    public void BinarySearchTest()
    {
        BinarySearchTree<Integer> tree = getHWSampleTree();
        System.out.println(tree.getStructure());
    }
    
    
    
    public MyFlatBinaryTree<String> getFlatTree()
    {
        MyFlatBinaryTree<String> tree = new MyFlatBinaryTree<>();
        String[] array = new String[1];
        tree.data = array;
        return tree;
    }
    
    public MyGeneralTree<String> getTree()
	{
//		|-- Root
//			|-- A
//				|-- A.1
//				|-- A.2
//				|-- A.3
//			|-- B
//				|-- B.1
//				|-- B.2
//					|-- B.2.a
//					|-- B.2.b
//				|-- B.3
//			|-- C
//				|-- C.1
//				|-- C.2
//				|-- C.3

		MyGeneralTree<String> tree = new MyGeneralTree<>("Root");

		MyGeneralTreeNode<String> root1 = new MyGeneralTreeNode("A");
		tree.root.children.add(root1);
		root1.children.add(new MyGeneralTreeNode("A.1"));
		root1.children.add(new MyGeneralTreeNode("A.2"));
		root1.children.add(new MyGeneralTreeNode("A.3"));

		MyGeneralTreeNode<String> root2 = new MyGeneralTreeNode<>("B");
		tree.root.children.add(root2);
		root2.children.add(new MyGeneralTreeNode<>("B.1"));
		root1 = new MyGeneralTreeNode<>("B.2");
		root2.children.add(root1);
		root1.children.add(new MyGeneralTreeNode<>("B.2.a"));
		root1.children.add(new MyGeneralTreeNode<>("B.2.b"));
		root2.children.add(new MyGeneralTreeNode<>("B.3"));

		MyGeneralTreeNode<String> root3 = new MyGeneralTreeNode<>("C");
		tree.root.children.add(root3);
		root3.children.add(new MyGeneralTreeNode<>("C.1"));
		root3.children.add(new MyGeneralTreeNode<>("C.2"));
		root3.children.add(new MyGeneralTreeNode<>("C.3"));

		return tree;
	}
    public MyFlatBinaryTree<String> getFullTree()
	{
//				A				1
//			B        C			1+2= 3
//		 D    E    F    G		3+4= 7
//		H I  J K  L M  N O		7+8=15

		MyFlatBinaryTree<String> tree = new MyFlatBinaryTree<>();
		String[] treeData = new String[]
		{
			null,
			"A",
			"B", "C",
			"D", "E", "F", "G",
			"H", "I", "J", "K", "L","M","N","O"
		};
		tree.data = treeData;
		return tree;
	}


public BinarySearchTree<Integer> getHWSampleTree()
	{
//		|-- 8
//			|-- 3
//				|-- 1
//				|-- 6
//					|-- 4
//					|-- 7
//			|-- 10
//				|-- 14
//					|-- 13

		BinarySearchTree<Integer> bst = new BinarySearchTree();
                
		bst.add(8);
		bst.add(3);
		bst.add(6);
		bst.add(10);
		bst.add(14);
		bst.add(4);
		bst.add(7);
		bst.add(1);
		bst.add(13);
		return bst;
	}
}
    

