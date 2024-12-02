package GFG;

public class NonRepeatingCharacter 
{
    static char nonRepeatingChar(String s) 
    {
        if(s.length() == 1)
        {
            return s.charAt(0);
        }
        
        int freq[] = new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int freqIndex = ch - 97;
            freq[freqIndex] += 1; 
        }
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int freqIndex = ch - 97;
            if(freq[freqIndex] == 1)
            {
                char res = (char) (freqIndex + 97);
                return res;
            }
        }
        
        return '$';   // When you return '$' driver code will output -1.
    }    
}
