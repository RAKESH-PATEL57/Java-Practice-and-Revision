package GFG;

public class MobileNumericKeypad {
    public int getCount(int n) {
        // code here
         if (n <= 0) return 0;
        if (n == 1) return 10; // All 10 digits can be pressed once
        
        // Keypad layout
        int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1} // -1 represents * and # which are not allowed
        };
        
        // Possible movements: current, up, down, left, right
        int[][] moves = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // dp[i][j][len] represents count of numbers starting with digit at position (i,j) with length 'len'
        int[][][] dp = new int[4][3][n+1];
        
        // Initialize for length 1
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] != -1) {
                    dp[i][j][1] = 1;
                }
            }
        }
        
        // Fill the dp table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keypad[i][j] != -1) {
                        for (int[] move : moves) {
                            int newRow = i + move[0];
                            int newCol = j + move[1];
                            
                            if (isValid(newRow, newCol, keypad)) {
                                dp[i][j][len] += dp[newRow][newCol][len-1];
                            }
                        }
                    }
                }
            }
        }
        
        // Sum up all possibilities for length n
        int total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] != -1) {
                    total += dp[i][j][n];
                }
            }
        }
        
        return total;
    }
    
    private boolean isValid(int i, int j, int[][] keypad) 
    {
        return i >= 0 && i < 4 && j >= 0 && j < 3 && keypad[i][j] != -1;
    }
}
