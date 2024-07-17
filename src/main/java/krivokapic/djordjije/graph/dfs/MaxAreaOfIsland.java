package krivokapic.djordjije.graph.dfs;

public class MaxAreaOfIsland {

    // https://leetcode.com/problems/max-area-of-island/description/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(rows * columns)
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;

        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int islandArea = dfs(grid, i, j);

                if (islandArea > maxIsland) {
                    maxIsland = islandArea;
                }
            }
        }

        return maxIsland;
    }


    int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }

        int area = 1;
        grid[i][j] = 0;

        if (i - 1 >= 0) {
            area += dfs(grid, i - 1, j);
        }

        if (i + 1 <= grid.length - 1) {
            area += dfs(grid, i + 1, j);
        }

        if (j - 1 >= 0) {
            area += dfs(grid, i, j - 1);
        }

        if (j + 1 <= grid[0].length - 1) {
            area += dfs(grid, i, j + 1);
        }

        return area;
    }

}
