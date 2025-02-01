public class WordSearch {
    private boolean solve(char[][] mat, String word, int i, int j, int idx, boolean[][] vis) {
        // Base case
        if (idx == word.length()) return true;
        
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j] || mat[i][j] != word.charAt(idx)) 
            return false;
        
        // Mark as visited
        vis[i][j] = true;
        
        // Recursive case
        if (solve(mat, word, i - 1, j, idx + 1, vis) ||
            solve(mat, word, i + 1, j, idx + 1, vis) ||
            solve(mat, word, i, j - 1, idx + 1, vis) ||
            solve(mat, word, i, j + 1, idx + 1, vis))
            return true;
        
        // Backtrack
        vis[i][j] = false;
        
        return false;
    }
    
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (solve(mat, word, i, j, 0, vis)) return true;
                }
            }
        }
        
        return false;
    }
}
