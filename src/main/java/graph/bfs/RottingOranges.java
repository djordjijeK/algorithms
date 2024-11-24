package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;


public class RottingOranges {

    // https://leetcode.com/problems/rotting-oranges/description/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(rows * columns)
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int freshOranges = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // count fresh oranges
                if (grid[i][j] == 1) {
                    freshOranges += 1;
                }

                // enqueue rotten oranges positions
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty() && freshOranges > 0) {
            int queueSize = queue.size();

            // process all queued rotten oranges positions
            while (queueSize > 0) {
                int[] position = queue.poll();
                queueSize -= 1;

                int row = position[0];
                int column = position[1];

                if (row - 1 >= 0 && grid[row - 1][column] == 1) {
                    grid[row - 1][column] = 2;
                    queue.offer(new int[]{row - 1, column});
                    freshOranges--;
                }

                if (row + 1 < grid.length && grid[row + 1][column] == 1) {
                    grid[row + 1][column] = 2;
                    queue.offer(new int[]{row + 1, column});
                    freshOranges--;
                }

                if (column - 1 >= 0 && grid[row][column - 1] == 1) {
                    grid[row][column - 1] = 2;
                    queue.offer(new int[]{row, column - 1});
                    freshOranges--;
                }

                if (column + 1 < grid[0].length && grid[row][column + 1] == 1) {
                    grid[row][column + 1] = 2;
                    queue.offer(new int[]{row, column + 1});
                    freshOranges--;
                }
            }

            // increase time elapsed
            time += 1;
        }

        return freshOranges == 0 ? time : -1;
    }

}
