package krivokapic.djordjije;


import java.util.ArrayDeque;
import java.util.Queue;


// https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                result++;
                bfs(i, j ,grid);
            }
        }

        return result;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(i,j));

        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (pair.i - 1 >= 0 && grid[pair.i - 1][pair.j] == '1') {
                grid[pair.i - 1][pair.j] = '0';
                queue.offer(new Pair(pair.i - 1, pair.j));
            }

            if (pair.i + 1 < grid.length && grid[pair.i + 1][pair.j] == '1') {
                grid[pair.i + 1][pair.j] = '0';
                queue.offer(new Pair(pair.i + 1, pair.j));
            }

            if (pair.j - 1 >= 0 && grid[pair.i][pair.j - 1] == '1') {
                grid[pair.i][pair.j - 1] = '0';
                queue.offer(new Pair(pair.i, pair.j - 1));
            }

            if (pair.j + 1 < grid[0].length && grid[pair.i][pair.j + 1] == '1') {
                grid[pair.i][pair.j + 1] = '0';
                queue.offer(new Pair(pair.i, pair.j + 1));
            }
        }
    }

    private record Pair(int i, int j) {}
}
