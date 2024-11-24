package graph.dfs;

import java.util.Arrays;


public class SurroundedRegions {

    // https://leetcode.com/problems/surrounded-regions/description/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(rows * columns)
    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

        for (int column = 0; column < columns; column++) {
            if (board[0][column] == 'O') {
                dfs(board, 0, column, rows, columns);
            }

            if (board[rows - 1][column] == 'O') {
                dfs(board, rows - 1, column, rows, columns);
            }
        }

        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0, rows, columns);
            }

            if (board[row][columns - 1] == 'O') {
                dfs(board, row, columns - 1, rows, columns);
            }
        }

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 'T') {
                    board[row][column] = 'O';
                } else {
                    board[row][column] = 'X';
                }
            }
        }
    }


    void dfs(char[][] board, int i, int j, int rows, int columns) {
        if (i < 0 || i == rows || j < 0 || j == columns || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        dfs(board, i - 1, j, rows, columns);
        dfs(board, i + 1, j, rows, columns);
        dfs(board, i, j - 1, rows, columns);
        dfs(board, i, j + 1, rows, columns);
    }

}
