package GFG;

public class CuttingBinaryString {
    public int cuts(String s) {
        int n = s.length();
        // dp[i] represents minimum cuts needed for substring s[0...i]
        int[] dp = new int[n + 1];
        
        // Initialize with maximum possible value
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE; // Use a very large value instead of i
        }
        
        // Base case
        dp[0] = 0;
        
        // Fill dp array
        for (int i = 1; i <= n; i++) {
            // Try all possible substrings ending at position i
            for (int j = 0; j < i; j++) {
                // Extract substring from j to i-1
                String sub = s.substring(j, i);
                
                // Check if substring has leading zeros or is empty
                if (sub.length() > 0 && sub.charAt(0) == '0') {
                    continue;
                }
                
                // Check if the substring represents a power of 5
                if (isPowerOfFive(sub)) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        
        // If dp[n] is still the initialized value, it means it's not possible
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
    
    private boolean isPowerOfFive(String s) {
        if (s.isEmpty()) return false;
        
        // Convert binary string to decimal
        long num = 0;
        for (char c : s.toCharArray()) {
            num = num * 2 + (c - '0');
        }
        
        // 1 is 5^0
        if (num == 1) return true;
        
        // Check if it's a power of 5
        if (num == 0) return false; // 0 is not a power of 5
        
        while (num > 1) {
            if (num % 5 != 0) return false;
            num /= 5;
        }
        return true;
    }
}
