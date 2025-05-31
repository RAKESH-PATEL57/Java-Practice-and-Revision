package GFG;

public class KthElementInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0]; // Smallest element in the matrix
        int high = matrix[n-1][n-1]; // Largest element in the matrix
        
        // Binary search on the range of values
        while (low < high) 
        {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(matrix, mid);
            
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
        
    }
    
    private int countLessOrEqual(int[][] matrix, int target) {
    int n = matrix.length;
    int count = 0;
    int row = 0;
    int col = n - 1;
    
    // Start from top-right corner and move left or down
    while (row < n && col >= 0) 
    {
        if (matrix[row][col] <= target) 
        {
            // All elements in current row up to col are <= target
            count += (col + 1);
            row++; // Move to next row
        } else {
            col--; // Move left in current row
        }
    }
    
    return count;
 }
}
