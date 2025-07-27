package GFG;

public class SetMatrixZeros {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Use first row and first column to track which rows/columns should be zeroed
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if first row has any zeros
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check if first column has any zeros
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Use first row and first column to mark which rows and columns need to be
        // zeroed
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0; // Mark the first cell in this row
                    mat[0][j] = 0; // Mark the first cell in this column
                }
            }
        }

        // Zero out rows based on markers in first column
        for (int i = 1; i < n; i++) {
            if (mat[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero out columns based on markers in first row
        for (int j = 1; j < m; j++) {
            if (mat[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero out first row if needed
        if (firstRowHasZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        // Zero out first column if needed
        if (firstColHasZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
