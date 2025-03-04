package GFG;

public class MaxSumSubarrayOfSizeK {
    public int maximumSumSubarray(int[] arr, int k) 
    {
        int maxSum = 0;
        int sum = 0;
        int ln = arr.length;
        
        for(int i=0;i<k;i++)
        {
            maxSum += arr[i];
        }
        
        sum = maxSum;
        
        for(int i=k;i<ln;i++)
        {
            sum = sum - arr[i-k] + arr[i];
            maxSum = sum > maxSum ? sum : maxSum;
        }
        
        return maxSum;
    }
}
