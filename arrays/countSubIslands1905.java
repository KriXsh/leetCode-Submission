class countSubIslands1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we find a land cell in grid2 that hasn't been visited
                if (grid2[i][j] == 1) {
                    // Check if this island is a sub-island
                    if (isSubIsland(grid1, grid2, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j, int m, int n) {
        // If out of bounds or the cell is water in grid2, return true (base case)
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }

        // If the current cell in grid2 is land, but not in grid1, it's not a sub-island
        if (grid2[i][j] == 1 && grid1[i][j] == 0) {
            return false;
        }

        // Mark the cell as visited in grid2
        grid2[i][j] = 0;

        // Perform DFS in all four directions
        boolean top = isSubIsland(grid1, grid2, i - 1, j, m, n);
        boolean bottom = isSubIsland(grid1, grid2, i + 1, j, m, n);
        boolean left = isSubIsland(grid1, grid2, i, j - 1, m, n);
        boolean right = isSubIsland(grid1, grid2, i, j + 1, m, n);

        // The current island is a sub-island only if all directions return true
        return top && bottom && left && right;
    }
}
