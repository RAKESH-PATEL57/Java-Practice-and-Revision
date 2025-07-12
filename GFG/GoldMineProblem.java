package GFG;

public class GoldMineProblem {
    public int maxGold(int[][] mat) {
        // code here
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return 0;
            
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns
        
        // Start from the second-last column and move backwards
        for (int col = m-2; col >= 0; col--)
        {
            for (int row = 0; row < n; row++)
            {
                // Calculate the maximum gold by considering the three possible moves
                
                // Right move
                int right = mat[row][col+1];
                
                // Right-up diagonal move (if valid)
                int rightUp = (row > 0) ? mat[row-1][col+1] : 0;
                
                // Right-down diagonal move (if valid)
                int rightDown = (row < n-1) ? mat[row+1][col+1] : 0;
                
                // Update the current cell with the maximum gold possible from this position
                mat[row][col] += Math.max(right, Math.max(rightUp, rightDown));
            }
        }
        
        // Find maximum gold from first column (starting positions)
        int maxGold = 0;
        for (int i = 0; i < n; i++)
        {
            maxGold = Math.max(maxGold, mat[i][0]);
        }
        
        return maxGold;
    }
}
