package GFG;

public class SumOfNodesOnTheLongestPath {
    int path = 0;
    int sum = 0;
    
    void solve(Node root, int currLen, int currSum) 
    {
      
        if (root == null) 
        {
            if (currLen > path) 
            {
                path = currLen;
                sum = currSum;
            }
            
            else if (currLen == path) 
            {
                sum = Math.max(sum, currSum);
            }
            return;
        }
        
        solve(root.left, currLen + 1, currSum + root.data);
        solve(root.right, currLen + 1, currSum + root.data);
    }
    
    // Public method to find sum of longest root-to-leaf path
    public int sumOfLongRootToLeafPath(Node root) {
        
        path = 0;
        sum = 0;
        
        solve(root, 0, 0);
        
        return sum;
    }
}
