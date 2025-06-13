package GFG;

public class StringDuplicatesRemoval {
    String removeDuplicates(String s) {
        
        int ln = s.length();
        
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<ln;i++)
        {
            char ch = s.charAt(i);
          
            
            if(res.indexOf(String.valueOf(ch)) == -1)
            {
                res.append(ch);
            }
        }
        
        
        return res.toString();
        
        
    }
}
