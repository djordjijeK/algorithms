package graph;

public class NumberOfEnclaves {
    // https://leetcode.com/problems/number-of-enclaves/
    // Time Complexity: O(row * columns)
    // Space Complexity: O(1)
    public int numEnclaves(int[][] grid) {
        int enclaves = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int[] localEnclaves = new int[1];

                    if (dfs(grid, i, j, localEnclaves)) {
                        enclaves += localEnclaves[0];
                    }
                    ;

                    System.out.println(localEnclaves[0]);
                }
            }
        }

        return enclaves;
    }


    public boolean dfs(int[][] grid, int i, int j, int[] enclaves) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }

        if (grid[i][j] == 0) {
            return true;
        }

        grid[i][j] = 0;
        enclaves[0] += 1;

        boolean left = dfs(grid, i - 1, j, enclaves);
        boolean right = dfs(grid, i + 1, j, enclaves);
        boolean up = dfs(grid, i, j - 1, enclaves);
        boolean down = dfs(grid, i, j + 1, enclaves);

        return left && right && up && down;
    }
}
