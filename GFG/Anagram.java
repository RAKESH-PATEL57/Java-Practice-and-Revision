package GFG;

import java.util.Arrays;

public class Anagram 
{

    // method one   (see method two for get the Optimized Answers 😊)
     public static boolean Anagrams(String s1, String s2) 
    {
        
        if(s1.length() != s2.length())
        {
            return false;
        }
        
        char arrS1[] = s1.toCharArray();
        char arrS2[] = s2.toCharArray();
        
        Arrays.sort(arrS1);
        Arrays.sort(arrS2);
        
        int indexS1 = 0;
        int indexS2 = 0;
        
        int ln = s1.length();
        
        while((indexS1 < ln) && (indexS2 < ln))
        {
            if(arrS1[indexS1] != arrS2[indexS2])
            {
                return false;
            }
            
            indexS1++;
            indexS2++;
        }
        
        return true;

        // Your code here
    }

    // method two
    public static boolean areAnagrams(String s1, String s2) 
    {
        
        if(s1.length() != s2.length())
        {
            return false;
        }
        
        int freq[] = new int[26];
        
        int indexS1 = 0;
        int indexS2 = 0;
        
        int len = s1.length();
        
        while((indexS1 < len) && (indexS2 < len))
        {
            char charS1 = s1.charAt(indexS1);
            int freqIndexS1 = charS1 - 97;
            freq[freqIndexS1] +=1;
            
            char charS2 = s2.charAt(indexS2);
            int freqIndexS2 = charS2 - 97;
            freq[freqIndexS2] -=1;
            
            indexS1++;
            indexS2++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(freq[i] != 0)
            {
                return false;
            }
        }
        
        return true;

        // Your code here
    }
    
}
