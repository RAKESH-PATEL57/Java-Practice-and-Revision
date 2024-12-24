package GFG;

public class SearchInARowColumnSortedMatrix {
    // O(n^2) time complexity (brute force) 
    public static boolean matSearch(int mat[][], int x) 
    {
    
       int rowLen = mat.length;
       int colLen = mat[0].length;
       
       for(int i=0;i<rowLen;i++)
       {
           for(int j=0;j<colLen;j++)
           {
               if(mat[i][j] == x)
               {
                   return true;
               }
           }
       }
       
       return false;
    }

    //O(n + m) (Staircase Search)
    // n is the number of rows.
    // m is the number of columns.

    public static boolean matSearch(int mat[][], int x) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
    
        // Start from the top-right corner
        int i = 0, j = colLen - 1;
    
        while (i < rowLen && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] > x) {
                j--; // Move left
            } else {
                i++; // Move down
            }
        }
    
        return false; // Element not found
    }


}
