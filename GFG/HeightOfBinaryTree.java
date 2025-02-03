package GFG;

import org.w3c.dom.Node;

public class HeightOfBinaryTree {
    int height(Node node) 
    {
        if(node == null)
        {
            return 0;
        }
        
        int res = calc(node) -1;
        return res;
    }
    
    int calc(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return Math.max(calc(root.left),calc(root.right))+1;
    }
}
