package training.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class NQueens {

    // https://leetcode.com/problems/n-queens/description/
    // Time Complexity:
    // Space Complexity:
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();

        Set<Integer> columns = new HashSet<>();
        Set<Integer> positiveDiagonal = new HashSet<>();
        Set<Integer> negativeDiagonal = new HashSet<>();

        char[][] board = createBoard(n);
        backtrack(board, 0, n, boards, columns, positiveDiagonal, negativeDiagonal);

        return boards;
    }


    private void backtrack(char[][] board, int row, int n, List<List<String>> boards, Set<Integer> columns, Set<Integer> positiveDiagonal, Set<Integer> negativeDiagonal) {
        if (row == n) {
            List<String> copy = new ArrayList<>();
            for (char[] r : board) {
                copy.add(new String(r));
            }

            boards.add(copy);
            return;
        }

        for (int column = 0; column < n; column++) {
            if (columns.contains(column) || positiveDiagonal.contains(row - column) || negativeDiagonal.contains(row + column)) {
                continue;
            }

            columns.add(column);
            positiveDiagonal.add(row - column);
            negativeDiagonal.add(row + column);
            board[row][column] = 'Q';

            backtrack(board, row + 1, n, boards, columns, positiveDiagonal, negativeDiagonal);

            columns.remove(column);
            positiveDiagonal.remove(row - column);
            negativeDiagonal.remove(row + column);
            board[row][column] = '.';
        }
    }


    private char[][] createBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return board;
    }
}
