package GFG;

public record Searchinarowwisesortedmatrix() {
    //binary search ( n log m)
    public boolean searchRowMatrix(int[][] mat, int x)
    {
        int rowLen = mat.length;
        
        for (int i = 0; i < rowLen; i++) 
        {
            // Perform binary search on each row
            if(binarySearch(mat[i], x)) 
            {
                return true; // Element found in the current row
            }
        }
        
        return false;
    }
    
    private boolean binarySearch(int[] row, int x) 
    {
        int start = 0;
        int end = row.length - 1;
    
        while (start <= end) {
            int mid = start + (end - start) / 2; // Avoid overflow
            if (row[mid] == x) {
                return true; // Element found
            } else if (row[mid] < x) {
                start = mid + 1; // Search right half
            } else {
                end = mid - 1; // Search left half
            }
        }
    
        return false; // Element not found in this row
    }
}
