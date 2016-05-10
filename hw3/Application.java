/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw3;

/**
 *
 * @author paidforbyoptions
 */
public class Application 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Application app = new Application();
        //app.DEQueueTest();
        //app.biasedQueueTest();
        //app.LinkedListTest();
        //app.bracesTest();
        //app.stackTest();
        //app.arrayListTest();
        app.reverseTest();
        //app.DestructiveListTest();
    }
    
    public void DEQueueTest()
    {
        MyDEQueue<Double> queue = new MyDEQueue<>();
        queue.pushToFront(1.0);
        queue.pushToFront(2.0);
        queue.pushToFront(3.0);
        queue.pushToFront(5.0);
        
        //queue.add(44.0);
//        System.out.println("pop gives: " + queue.pop());
//        System.out.println("queue stuff:");
//        System.out.println("is empty:" + queue.isEmpty());
//        System.out.println("now I clear it:");
//        queue.clear();
//        System.out.println("is empty;" + queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        
    }
    
    public void biasedQueueTest()
        {
            MyBiasedQueue<String> bias = new MyBiasedQueue<>("fuck");
//              bias.Push("fuck");
//              bias.Push("one");
//            bias.Push("two");
//            bias.Push("three");
//            bias.Push("fuck");
//            bias.Push("fuck");            
//            bias.Push("four");
//            bias.Push("five");
//            bias.Push("six");
            
            int size = bias.getSize();
            System.out.println("size = " + bias.getSize());
            for (int i = 0; i < size; i++)
            {                
                
                System.out.println(bias.pop());
            }
//            System.out.println(bias.pop());
//            System.out.println(bias.pop());
//            System.out.println(bias.pop());
//            System.out.println(bias.pop());
//            System.out.println(bias.pop());
//            System.out.println(bias.pop());
//            System.out.println(bias.pop());
             
             
        }
    
    
    public void LinkedListTest()
    {
        
        MyLinkedList<Integer> list = new MyLinkedList<>();
        
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//        list.add("five");
//        list.add("six");
//        list.add("seven");
//        list.add("eight");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        
        //list.insert(8, "fuck");
        //list.removeRange(3,7);
        //list.remove(7);
        //list.clear();
        //list.getSize();        
        //list.update(0, "fuck");
        list.insert(8, 120);
        list.remove(8);
        System.out.println(list.contains(120));
        System.out.println("size = " +list.getSize());
        for (int i = 0; i < list.getSize(); i++)
        {
            System.out.println(list.get(i));
        }
       
        //System.out.println("calling list.contains(6) gives: "+ list.contains("five"));
//        System.out.println("calling removerange(2,5) gives " );
//        for (int i = 0; i < list.getSize(); i++)
//        {
//            System.out.println(list.get(i));
//        }
    }
    
    public void bracesTest()
    {
        BraceChecker check = new BraceChecker();
        
        String[] code = new String[3];
        code[0] = "[abc]";
        code[1] = ")(adsfa)";
        code[2] = "()";
       
        
        
        System.out.println(check.findError(code) );
    }
    
    public void stackTest()
    {
        MyArrayStack<String> stack = new MyArrayStack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        stack.push("six");
        stack.push("seven");
        stack.push("eight");
        System.out.println("begin popping: ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //stack.clear();
        System.out.println("peeking gives : " + stack.peek());
        System.out.println("size = " + stack.getSize());
        
        
//        for (int i = 0; i < 12; i++)
//        {
//            System.out.println(stack.pop());
//        }
        
       // System.out.println(stack.getSize());
    }
    
    
    public void arrayListTest()
    {
        String[] strings = new String[10];
        strings[1] = "one";
        strings[5] = "two";
        strings[9] = "three";
        MyArrayList<String> list = new MyArrayList<String>(strings);
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("eleven");
        list.add("twelve");
       // list.addAll(strings);
        //list.clear();
        //list.add("fuck");
        
        //list.remove(10);
        //list.insert(1, "fuck");
//        System.out.println("list contains one: " + list.contains("one"));
        System.out.println("list looks like :");
        for(int i = 0; i < list.getSize(); i++)
        {
            System.out.println(list.get(i));
        }
        
        System.out.println("size = " );
        System.out.println(list.getSize());
    }
    
    public void reverseTest()
    {
        MyReversableLinkedList<String> list = new MyReversableLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        System.out.println("List looks like: ");
        for (int i = 0; i < list.getSize(); i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println("*********");
        //list.reverse();
        list.remove(0);
        System.out.println("After reversing, list looks like: ");
        for(int i = 0; i < list.getSize(); i++)
        {
            System.out.println(list.get(i));
        }
    }
    
    public void DestructiveListTest()
    {
        DestructiveList<String> list = new DestructiveList<>();
        list.add("one");
        list.add("one");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("four");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("seven");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("ten");
        list.add("ten");
        
//        list.add("b");
//        
//        list.add("a");
//        list.add("a");
//        list.add("a");
//        list.add("a");
//        list.add("a");
//        list.add("a");
        
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//        list.add("F");
//        list.add("G");
//        list.add("H");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//        list.add("F");
//        list.add("A");
//        list.add("B");
        
                
        
        
        int size = list.getSize();
        System.out.println("list looks like: ");
        for (int i = 0 ; i < size; i++)
        {
            System.out.println(list.get(i));            
        }
        System.out.println("*********");
        
        //System.out.println("calling remove(1, 3) gives : ");
        //System.out.println("after calling remove(1, 3) list looks like: ");
        
        //System.out.println("calling rotate(3) gives: ");
        System.out.println("calling removegroupsof(3) gives: ");
        list.removeGroupsOf(3);
        //list.rotate(3);
        
        size = list.getSize();
        System.out.println("size = " + size);
        System.out.println("now list looks like : ");
        for (int i = 0 ; i < size; i++)
        {
            System.out.println(list.get(i));            
        }
//        System.out.println("After calling removeEvery(3) list looks like: ");
//        for (int i = 0 ; i < list.getSize(); i++)
//        {
//            System.out.println(list.get(i));            
//        }
    }
           
}
