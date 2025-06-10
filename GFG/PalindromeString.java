package GFG;

public class PalindromeString {
    boolean isPalindrome(String s) 
    {
        int ln = s.length();
        
        StringBuilder revStr = new StringBuilder();
       
        
        for(int i=ln-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            
            revStr.append(ch);
            
        }
        
        // System.out.println(temp);
        
        if(revStr.toString().equals(s))
        {
            return true;
        }
        
        return false;
        
    }
}
