package GFG;

public class RotateByNinetyDegree {
    static void rotateby90(int mat[][]) 
    {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        
        // Reverse each row
        for (int i = 0; i < rowLen; i++) {
            int start = 0, end = colLen - 1;
            while (start < end) {
                // Swap elements to reverse the row
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
        
        // Transpose the matrix
        for (int i = 0; i < rowLen; i++) {
            for (int j = i + 1; j < colLen; j++) {
                // Swap elements to transpose
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

    }
}
