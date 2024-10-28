package graph;


public class NumberOfClosedIslands {
    // https://leetcode.com/problems/number-of-closed-islands/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(1)
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int columns = grid[0].length;

        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                // start searching when we hit the land
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    result += 1;
                }
            }
        }

        return result;
    }


    boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }

        // if it's the water, stop the DFS
        if (grid[i][j] == 1) {
            return true;
        }

        // mark the current cell as visited
        grid[i][j] = 1;

        boolean left = dfs(grid, i - 1, j);
        boolean right = dfs(grid, i + 1, j);
        boolean top = dfs(grid, i, j + 1);
        boolean bottom = dfs(grid, i, j - 1);

        return top && bottom && left && right;
    }
}
