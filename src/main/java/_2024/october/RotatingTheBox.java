package _2024.october;

public class RotatingTheBox {
    // https://leetcode.com/problems/rotating-the-box/
    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n)
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int columns = box[0].length;

        for (int i = 0; i < rows; i++) {

            int left = 0;
            int right = 0;
            while (right < columns) {
                if (box[i][right] == '.') {
                    while (left < right && box[i][left] != '#') {
                        left++;
                    }

                    box[i][right] = '#';
                    box[i][left] = '.';
                } else if (box[i][right] == '*') {
                    left = right;
                }

                right++;
            }
        }

        char[][] result = new char[columns][rows];
        for (int i = rows; i >= 0; --i) {
            for (int j = 0; j < columns; j++) {
                result[j][rows - i] = box[i][j];
            }
        }

        return result;
    }
}
