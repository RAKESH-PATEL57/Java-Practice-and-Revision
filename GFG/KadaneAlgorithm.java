package GFG;

public class KadaneAlgorithm 
{
    int maxSubarraySum(int[] arr) 
    {
        int ln = arr.length;
        
        int sum = 0;
        int res=Integer.MIN_VALUE;
        
        for(int i=0;i<ln;i++)
        {
            sum = sum + arr[i];
            
            res = Math.max(sum,res);
        
            if(sum < 0)
            {
                sum = 0;
            }
            
        }
        // Your code here
        
        
        return res;
    }    
}
