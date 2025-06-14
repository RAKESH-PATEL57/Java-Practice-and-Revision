package GFG;

import java.util.Stack;

public class ReverseUsingStack {
    public String reverse(String S) {
        // code here
        Stack<Character> st = new Stack<>();
        
        
        int ln = S.length();
        
        if(ln == 1)
        {
            return S;
        }
        
        
        for(int i=0;i<ln;i++)
        {
            
            char ch = S.charAt(i);
            
            st.push(ch);
            
        }
        
        StringBuilder res = new StringBuilder();
        
        while (!st.isEmpty()) 
        {
            res.append(st.pop());
        }
        
        return res.toString();
    }
}
