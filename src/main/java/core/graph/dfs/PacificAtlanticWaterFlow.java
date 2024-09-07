package core.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PacificAtlanticWaterFlow {

    // https://leetcode.com/problems/pacific-atlantic-water-flow/description/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(rows * columns)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        // store coordinates that can reach pacific ocean
        Set<Integer> canReachPacificOcean = new HashSet<>();

        // store coordinates that can reach atlantic ocean
        Set<Integer> canReachAtlanticOcean = new HashSet<>();

        for (int column = 0; column < columns; column++) {
            dfs(heights, 0, column, heights[0][column], canReachPacificOcean, rows, columns);
            dfs(heights, rows - 1, column, heights[rows - 1][column], canReachAtlanticOcean, rows, columns);
        }

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, heights[row][0], canReachPacificOcean, rows, columns);
            dfs(heights, row, columns - 1, heights[row][columns - 1], canReachAtlanticOcean, rows, columns);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int coordinate = i * columns + j;

                // if coordinate can reach both oceans put it to the result set
                if (canReachPacificOcean.contains(coordinate) && canReachAtlanticOcean.contains(coordinate)) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }


    public void dfs(int[][] heights, int i, int j, int previousHeight, Set<Integer> visited, int rows, int columns) {
        int coordinate = i * columns + j;

        if (i < 0 || i == rows || j < 0 || j == columns || heights[i][j] < previousHeight || visited.contains(coordinate)) {
            return;
        }

        visited.add(coordinate);

        dfs(heights, i - 1, j, heights[i][j], visited, rows, columns);
        dfs(heights, i + 1, j, heights[i][j], visited, rows, columns);
        dfs(heights, i, j - 1, heights[i][j], visited, rows, columns);
        dfs(heights, i, j + 1, heights[i][j], visited, rows, columns);
    }

}
