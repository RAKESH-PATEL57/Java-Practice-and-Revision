package GFG;

import java.util.Stack;

public class ParenthesisChecker {
    static boolean isBalanced(String s) {
        
        Stack<Character> charStack = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if( (s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{') )
            {
                charStack.push(s.charAt(i));
            }
            else
            {
                if( 
                    (!charStack.empty()) && (
                       ( (charStack.peek() == '(') && (s.charAt(i)==')') ) ||
                       ( (charStack.peek() == '[') && (s.charAt(i)==']') ) ||
                       ( (charStack.peek() == '{') && (s.charAt(i)=='}') )
                    )
                  )
                  {
                     charStack.pop(); 
                  }
                  
                  else
                  {
                      return false;
                  }
            }
        }
        
        return charStack.empty();
    }
}
