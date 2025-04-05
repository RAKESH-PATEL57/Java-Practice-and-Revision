package GFG;

public class FindtheNumberofIslands {
    static void dfs(char[][] grid, int r, int c)
    {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= col
            || grid[r][c] != 'L') {
            return;
        }
        int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };
        grid[r][c] = 'W';
        for (int k = 0; k < 8; ++k) {
            int newR = r + rNbr[k];
            int newC = c + cNbr[k];

            dfs(grid, newR, newC);
        }
    }

    static int countIslands(char[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (grid[r][c] == 'L') {
                    dfs(grid, r, c);
                    ++count;
                }
            }
        }
        return count;
    }
}
