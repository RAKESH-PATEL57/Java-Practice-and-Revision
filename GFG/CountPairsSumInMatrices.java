public class CountPairsSumInMatrices {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        HashSet<Integer> mat2Set = new HashSet<>();
        int ans = 0;
    
        // Add all elements of mat2 to the set
        for (int i = 0; i < mat2.length; i++) 
        {
            for (int j = 0; j < mat2[0].length; j++) 
            {
                mat2Set.add(mat2[i][j]);
            }
        }
    
        // For every element in mat1, check if x - mat1[i][j] exists in mat2Set
        for (int i = 0; i < mat1.length; i++) 
        {
            for (int j = 0; j < mat1[0].length; j++) 
            {
                int reqNum = x - mat1[i][j];
                if (mat2Set.contains(reqNum)) 
                {
                    ans++;
                }
            }
        }

    return ans;
        
    }
}
