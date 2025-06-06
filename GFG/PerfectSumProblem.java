package GFG;

public class PerfectSumProblem {
    public int perfectSum(int[] nums, int target) {
        // code here
       int[] dp = new int[target + 1];
    
        dp[0] = 1;
        
        for (int num : nums) 
        {

            for (int j = target; j >= num; j--) 
            {
                dp[j] += dp[j - num];
            }
        }
    
         return dp[target];
    }
}
