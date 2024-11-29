package GFG;

public class MaxCircularSubarraySum 
{
    public int circularSubarraySum(int arr[]) 
    {
        int res = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int curr = 0;
        int currNeg = 0;
        
        for(int i: arr)
        {
            res += i;
            curr = Math.max(curr+i, i);
            maxSum = Math.max(curr, maxSum);
            
            currNeg = Math.min(i, currNeg+i);
            minSum = Math.min(minSum, currNeg);
        }
        
        if(res ==  minSum)
        {
            return maxSum;
        }
        
        return Math.max(maxSum, res-minSum);
        // Your code here
    }    
}
