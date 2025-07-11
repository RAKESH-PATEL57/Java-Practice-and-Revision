package GFG;

public class TrailOfOnes {
     public int countConsec(int n) {
        // code here
        if (n <= 1) return 0; // No consecutive 1's possible with length 0 or 1
        
        // Total possible binary strings of length n is 2^n
        int totalStrings = 1 << n; // equivalent to 2^n
        
        // Count strings WITHOUT consecutive 1's using dynamic programming
        // Then subtract from total to get strings WITH consecutive 1's
        
        // dp[i][0] = number of binary strings of length i ending with 0, no consecutive 1's
        // dp[i][1] = number of binary strings of length i ending with 1, no consecutive 1's
        int[][] dp = new int[n + 1][2];
        
        // Base case: strings of length 1
        dp[1][0] = 1; // "0"
        dp[1][1] = 1; // "1"
        
        // Build up strings without consecutive 1's
        for (int i = 2; i <= n; i++) {
            // If current digit is 0, we can append it to any string without creating consecutive 1's
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            
            // If current digit is 1, we can only append it to strings ending with 0
            // to avoid consecutive 1's
            dp[i][1] = dp[i-1][0];
        }
        
        // Total strings without consecutive 1's
        int stringsWithoutConsecutiveOnes = dp[n][0] + dp[n][1];
        
        // Return strings with at least one pair of consecutive 1's
        return totalStrings - stringsWithoutConsecutiveOnes;
    }
}
