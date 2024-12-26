package GFG;

public class SetMatrixZeroes {
    public void setMatrixZeroes(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
    
        // Check if the first column contains any zero
        for (int i = 0; i < rows; i++) {
            if (mat[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
    
        // Check if the first row contains any zero
        for (int j = 0; j < cols; j++) {
            if (mat[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
    
        // Use the first row and column to mark zeros
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
    
        // Set matrix cells to zero based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
    
        // Update the first row if needed
        if (isFirstRowZero) {
            for (int j = 0; j < cols; j++) {
                mat[0][j] = 0;
            }
        }
    
        // Update the first column if needed
        if (isFirstColZero) {
            for (int i = 0; i < rows; i++) {
                mat[i][0] = 0;
            }
        }
        
    }
}   
