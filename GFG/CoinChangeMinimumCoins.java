package GFG;

public class CoinChangeMinimumCoins {
    static int minCoins(int[] coins, int sum) {
        int[][] dp = new int[coins.length][sum + 1];

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int take = Integer.MAX_VALUE, noTake = Integer.MAX_VALUE;

                // If we take coins[i] coin
                if (j - coins[i] >= 0) {
                    take = dp[i][j - coins[i]];
                    if (take != Integer.MAX_VALUE) take++;
                }
                  // not take the coin 
                if (i + 1 < coins.length) noTake = dp[i + 1][j];

                dp[i][j] = Math.min(take, noTake);
            }
        }

        if (dp[0][sum] != Integer.MAX_VALUE) return dp[0][sum];
        return -1;
    }
}
