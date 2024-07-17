package krivokapic.djordjije.graph.dfs;


public class NumberOfIslands {

    // https://leetcode.com/problems/number-of-islands/description/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(rows * columns)
    public int numIslands(char[][] grid) {
        int islands = 0;

        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                dfs(grid, i, j);
                islands++;
            }
        }

        return islands;
    }


    void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        if (i - 1 >= 0) {
            dfs(grid, i - 1, j);
        }

        if (i + 1 <= grid.length - 1) {
            dfs(grid, i + 1, j);
        }

        if (j - 1 >= 0) {
            dfs(grid, i, j - 1);
        }

        if (j + 1 <= grid[0].length - 1) {
            dfs(grid, i, j + 1);
        }
    }

}
