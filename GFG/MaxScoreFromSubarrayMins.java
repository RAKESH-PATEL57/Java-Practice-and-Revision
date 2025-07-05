package GFG;

public class MaxScoreFromSubarrayMins {
    public int maxSum(int arr[]) {
        // code here
        int n = arr.length;
        if (n < 2) return 0;
        
        // One pass to find maximum score
        int maxScore = Integer.MIN_VALUE;
        
        // For every subarray of size >= 2
        for (int i = 0; i < n-1; i++) {
            // We only need to look at subarrays starting at i
            int smallest = arr[i];
            int secondSmallest = Integer.MAX_VALUE;
            
            // Find second smallest for subarrays [i...j]
            for (int j = i+1; j < n; j++) {
                // Update smallest and second smallest based on current element
                if (arr[j] <= smallest) {
                    // New element is smaller than or equal to smallest
                    secondSmallest = smallest;
                    smallest = arr[j];
                } else if (arr[j] < secondSmallest) {
                    // New element is between smallest and second smallest
                    secondSmallest = arr[j];
                }
                
                // Calculate score if we have valid values
                if (secondSmallest != Integer.MAX_VALUE) {
                    maxScore = Math.max(maxScore, smallest + secondSmallest);
                }
            }
        }
        
        return maxScore;
    }
}
