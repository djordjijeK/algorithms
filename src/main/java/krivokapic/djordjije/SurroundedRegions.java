package krivokapic.djordjije;

import java.util.Arrays;


// https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {

    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        for (int j = 0; j < columns; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }

            if (board[rows - 1][j] == 'O') {
                bfs(board, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }

            if (board[i][columns - 1] == 'O') {
                bfs(board, i, columns - 1);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = board[i][j] == 'T' ? 'O' : 'X';
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        if (i < 0 || j > board[0].length - 1 || i > board.length - 1 || j < 0 || board[i][j] == 'T' || board[i][j] == 'X') {
            return;
        }

        board[i][j] = 'T';

        bfs(board, i + 1, j);
        bfs(board, i - 1, j);
        bfs(board, i, j + 1);
        bfs(board, i, j - 1);
    }

}
