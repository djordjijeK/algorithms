package core.graph.dfs;

public class FloodFill {

    // https://leetcode.com/problems/flood-fill/description/
    // Time Complexity: O(rows * columns)
    // Space Complexity: O(rows * columns)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, image[sr][sc], color);
        }

        return image;
    }


    void dfs(int[][] image, int row, int column, int oldColor, int newColor) {
        if (image[row][column] != oldColor) {
            return;
        }

        image[row][column] = newColor;

        if (row - 1 >= 0) {
            dfs(image, row - 1, column, oldColor, newColor);
        }

        if (row + 1 <= image.length - 1) {
            dfs(image, row + 1, column, oldColor, newColor);
        }

        if (column - 1 >= 0) {
            dfs(image, row, column - 1, oldColor, newColor);
        }

        if (column + 1 <= image[0].length - 1) {
            dfs(image, row, column + 1, oldColor, newColor);
        }
    }

}
