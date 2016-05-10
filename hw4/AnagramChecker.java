package hw4;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 
 */
public class AnagramChecker
{
      public boolean areAnagramsHelper(String word1, String word2)
    {
        for (int i = 0; i < word1.length(); i++)
        {
            char character = word1.charAt(i);
            String letter = "" + character;
            //System.out.println(letter);
            int occurances1 = 0;
            int occurances2 = 0;
            word1 = clean(word1);
            word2 = clean(word2);
            
            for (int j = 0; j < word1.length(); j++)
            {
                String string = "" + word1.charAt(j);
                if (letter.equalsIgnoreCase(string) )
                {
                    occurances1++;
                }                                           
            }
            for (int k = 0; k < word2.length(); k++)
            {
                String string = "" + word2.charAt(k);
                if (letter.equalsIgnoreCase(string) )
                {
                    occurances2++;
                }
            }
            if (occurances1 != occurances2)
            {
                return false;
            }
            
        }
        return true;
    }
    
     public String clean(String candidate) // should return string without punctuation 
    {        
        String finalCandidate = "";
        for (int j = 0; j < candidate.length(); j++)
        {             
             char theCharacter = candidate.charAt(j);
             if (Character.isLetter(theCharacter))
             {
                 finalCandidate = finalCandidate + theCharacter;
             }
             
        }
        
        return finalCandidate.trim();
    }
    
     public boolean areAnagrams(String word1, String word2)
     {
         if (areAnagramsHelper(word1, word2))
         {
             if (areAnagramsHelper(word2,word1))
             {
                 return true;
             }
         }
         return false;
     }
    
    
    

	public List<String> getAnagrams(String word, List<String> candidates)
	{
            List<String> anagrams = new LinkedList<>();
            for (String candidate : candidates)
            {
                if (areAnagrams(word, candidate) )
                {
                    anagrams.add(candidate);
                }
            }
            return anagrams;
	}
        
}
