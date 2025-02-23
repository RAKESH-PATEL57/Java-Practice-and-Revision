package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
     public ArrayList<Integer> nextLargerElement(int[] arr) 
    {
       int ln = arr.length;
       
       ArrayList<Integer> res = new ArrayList<>();
       Stack<Integer> st = new Stack<>();
       
       
       for(int i=0;i<ln;i++)
       {
           res.add(-1);
       }
       
       for(int i=ln-1; i>=0;i--)
       {
           while(!st.empty() && st.peek() <= arr[i])
           {
               st.pop();
           }
           
           if(!st.empty())
           {
               res.set(i, st.peek());
           }
           
           st.push(arr[i]);
       }
       
       
       
       return res;
    }
}
