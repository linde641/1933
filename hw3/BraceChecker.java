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
public class BraceChecker 
{
    
    public int findError(String[] code)
    {
        MyArrayStack<Character> openers = new MyArrayStack<>();
        MyArrayStack<Character> closers = new MyArrayStack<>();
        
        for(int i = 0; i < code.length; i++)// loops populate the openers and closers stacks
        {
            for(int j = 0; j < code[i].length(); j++)
            {
                char c = code[i].charAt(j);
                
                
                if (c == '{' || c == '(' || c == '[')
                {
                    openers.push(c);
                }
                
                if (c == '}' || c == ')' || c == ']')
                {
                    if (openers.getSize() == 0)
                    {
                        return i;
                    }
                    char lastOpener = openers.pop();
                    String pair ="" + lastOpener + c ;
                   
                    if ( !pair.equals("[]") &&  !pair.equals("()") &&  !pair.equals("{}") )
                    {
                        return i;
                    }
                }
                
            }
        }
        if (openers.pop() != null )
        {
            return code.length;
        }

        return -1;
        
    }
    
}
