package GFG;

public class LengthOfTheLongestSubstring {
    int longestUniqueSubstring(String s) {
        // code here
        int maxLen = 0;
        StringBuilder currentSubstring = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            int existingPos = currentSubstring.indexOf(String.valueOf(ch));
            
            System.out.println(existingPos);
            
            if (existingPos != -1) 
            {
                currentSubstring.delete(0, existingPos + 1);
            }
            
            currentSubstring.append(ch);
            
            maxLen = Math.max(maxLen, currentSubstring.length());
        }
        
        return maxLen;
    }
}
