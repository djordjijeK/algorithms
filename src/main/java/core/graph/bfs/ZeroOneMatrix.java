package core.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;


public class ZeroOneMatrix {

    // https://leetcode.com/problems/01-matrix/description/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(rows * columns)
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] == 0) {
                    // enqueue cells with value of 0 as they have distance of 0
                    queue.offer(new int[]{i, j});
                } else {
                    // mark cell as unvisited if cell value is not 0
                    mat[i][j] = -1;
                }

            }
        }

        // [BFS] process the queue
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            // get the current cell coordinates
            int row = coordinate[0];
            int column = coordinate[1];

            // if left cell (from the current) has a value of -1 (not visited)
            // set its value to current cell value + 1 and queue it for processing
            if (row - 1 >= 0 && mat[row - 1][column] == -1) {
                mat[row - 1][column] = mat[row][column] + 1;
                queue.offer(new int[]{row - 1, column});
            }

            // if right cell (from the current) has a value of -1 (not visited)
            // set its value to current cell value + 1 and queue it for processing
            if (row + 1 <= mat.length - 1 && mat[row + 1][column] == -1) {
                mat[row + 1][column] = mat[row][column] + 1;
                queue.offer(new int[]{row + 1, column});
            }

            // if below cell (from the current) has a value of -1 (not visited)
            // set its value to current cell value + 1 and queue it for processing
            if (column - 1 >= 0 && mat[row][column - 1] == -1) {
                mat[row][column - 1] = mat[row][column] + 1;
                queue.offer(new int[]{row, column - 1});
            }

            // if upper cell (from the current) has a value of -1 (not visited)
            // set its value to current cell value + 1 and queue it for processing
            if (column + 1 <= mat[0].length - 1 && mat[row][column + 1] == -1) {
                mat[row][column + 1] = mat[row][column] + 1;
                queue.offer(new int[]{row, column + 1});
            }
        }

        return mat;
    }

}
