package krivokapic.djordjije.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class ValidSudoku {
    // https://leetcode.com/problems/valid-sudoku/description/
    // Time Complexity: O(n * m)
    // Space Complexity: O(n * m)
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer, HashSet<Character>> columns = new HashMap<>();
        Map<Integer, HashSet<Character>> cells = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (current == '.') {
                    continue;
                }

                HashSet<Character> rowsSet = rows.getOrDefault(i, new HashSet<>());
                if (rowsSet.contains(current)) {
                    return false;
                } else {
                    rowsSet.add(current);
                    rows.put(i, rowsSet);
                }

                HashSet<Character> columnsSet = columns.getOrDefault(j, new HashSet<>());
                if (columnsSet.contains(current)) {
                    return false;
                } else {
                    columnsSet.add(current);
                    columns.put(j, columnsSet);
                }

                int row = i / 3;
                int column = j / 3;
                HashSet<Character> cell = cells.getOrDefault(row * 3 + column, new HashSet<>());
                if (cell.contains(current)) {
                    return false;
                } else {
                    cell.add(current);
                    cells.put(row * 3 + column, cell);
                }
            }
        }

        return true;
    }
}
