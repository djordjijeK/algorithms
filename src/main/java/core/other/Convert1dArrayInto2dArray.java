package core.other;

public class Convert1dArrayInto2dArray {
    // https://leetcode.com/problems/convert-1d-array-into-2d-array/description/
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] array2d = new int[m][n];

        for (int i = 0; i < original.length; i++) {
            int row = i / n;
            int column = i - row * n;

            System.out.println(i + " ");
            System.out.println(i + " " + n + " " + row + " " + column);
            array2d[row][column] = original[i];
        }

        return array2d;
    }
}
