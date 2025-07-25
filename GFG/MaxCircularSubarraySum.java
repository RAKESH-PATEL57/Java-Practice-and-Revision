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
    
    //method-2
    public int maxCircularSum(int[] arr) {
    int n = arr.length;
    
    // Case 1: Find maximum subarray sum using Kadane's algorithm
    int maxKadane = kadane(arr);
    
    // Case 2: Find maximum circular subarray sum
    int totalSum = 0;
    for (int i = 0; i < n; i++) {
        totalSum += arr[i];
        // Invert the signs of array elements
        arr[i] = -arr[i];
    }
    
    // Find min subarray sum in inverted array (which is max in original)
    int maxCircular = totalSum + kadane(arr);
    
    // If all elements are negative, maxCircular will be 0
    // In that case, return maxKadane
    if (maxCircular == 0) {
        return maxKadane;
    }
    
    // Return the maximum of the two cases
    return Math.max(maxKadane, maxCircular);
}

// Kadane's algorithm to find maximum subarray sum
private int kadane(int[] arr) {
    int maxSoFar = arr[0];
    int maxEndingHere = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
        maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    
    return maxSoFar;
}
}
