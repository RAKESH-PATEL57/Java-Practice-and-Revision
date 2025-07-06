package GFG;

public class MaxScoreFromSubarrayMins {
    public int maxSum(int arr[]) {
        // code here
        int n = arr.length;
        if (n < 2) return 0;
        
        int maxScore = Integer.MIN_VALUE;
   
        for (int i = 0; i < n - 1; i++) 
        {
  
            int smallest = Math.min(arr[i], arr[i+1]);
            int secondSmallest = Math.max(arr[i], arr[i+1]);
            
 
            int currentSum = smallest + secondSmallest;
            maxScore = Math.max(maxScore, currentSum);
        }

        
        return maxScore;
    }
}
