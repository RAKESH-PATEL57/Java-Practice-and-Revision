package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class PrintLeafNodesFromPreorderTraversalOfBST {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> leaves = new ArrayList<>();
        int n = preorder.length;

        for (int i = 0, j = 1; j < n; i++, j++) 
        {
            boolean found = false;
            if (preorder[i] > preorder[j]) 
            {
                s.push(preorder[i]);
            } 
            else 
            {
                while (!s.isEmpty()) 
                {
                    if (preorder[j] > s.peek()) 
                    {
                        s.pop();
                        found = true;
                    }
                    else 
                    {
                        break;
                    }
                }
            }
            if (found) 
            {
                leaves.add(preorder[i]);
            }
        }
        
        leaves.add(preorder[n - 1]);

        return leaves;
    }
}
