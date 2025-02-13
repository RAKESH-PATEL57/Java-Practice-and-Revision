package GFG;

import java.util.ArrayList;

public class PairSumInBST {
     void storingInArray(Node root, ArrayList<Integer> temp)
    {
        if(root == null) return;
        storingInArray(root.left,temp);
        temp.add(root.data);
        storingInArray(root.right,temp);
    }
    
    boolean findTarget(Node root, int target) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        storingInArray(root,temp);
        
        int start = 0;
        int end = temp.size()-1;

        
        while(start < end)
        {
            int sum = temp.get(start) + temp.get(end);
            
            if(sum == target)
            {
                return true;
            }
            else if(sum < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        
        return false;
        
    }
}
