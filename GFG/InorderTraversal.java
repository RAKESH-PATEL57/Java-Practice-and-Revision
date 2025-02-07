package GFG;

import java.util.ArrayList;

public class InorderTraversal {
    ArrayList<Integer> inOrderTraversal(Node root,ArrayList<Integer> res)
    {
        if(root == null)
        {
            return res;
        }
        inOrderTraversal(root.left,res);
        res.add(root.data);
        inOrderTraversal(root.right,res);
        
        return res;
    }
    
    ArrayList<Integer> inOrder(Node root) 
    {
       ArrayList<Integer> res = new ArrayList<>();
      
       inOrderTraversal(root, res);
       
       return res;
    }
}
