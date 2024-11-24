package other;

import java.util.Arrays;


public class SpiralMatrixIV {
    // https://leetcode.com/problems/spiral-matrix-iv/description
    // Time Complexity: O(m * n)
    // Space Complexity: O(1)
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }

        int row = 0;
        int column = 0;
        int currentDirection = 0;
        int[][] DIRECTIONS = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        while (head != null) {
            matrix[row][column] = head.val;

            int newRow = row + DIRECTIONS[currentDirection][0];
            int newColumn = column + DIRECTIONS[currentDirection][1];

            if (Math.min(newRow, newColumn) < 0 || newRow >= m || newColumn >= n || matrix[newRow][newColumn] != -1) {
                currentDirection = (currentDirection + 1) % 4;
            }

            row += DIRECTIONS[currentDirection][0];
            column += DIRECTIONS[currentDirection][1];

            head = head.next;
        }

        return matrix;
    }


    static class ListNode {
        int val;
        ListNode next;


        public ListNode() {

        }


        public ListNode(int val) {
            this.val = val;
        }


        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
