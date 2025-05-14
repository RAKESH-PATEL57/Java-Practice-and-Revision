public class RemoveDuplicates {
    String removeDups(String s) {
        // code here
        String res = "";
        
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            String temp = String.valueOf(c);
           
            if(!res.contains(temp))
            {
               res += c;
            }
            
        }
        
        return res;
    }
}
