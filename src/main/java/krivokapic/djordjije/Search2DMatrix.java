package krivokapic.djordjije;


// https://leetcode.com/problems/search-a-2d-matrix/description/
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;

        int[] columnToSearch = new int[rows];
        for (int i = 0; i < rows; i++) {
            columnToSearch[i] = matrix[i][0];
        }

        int row = binarySearch(columnToSearch, target);
        if (matrix[row][0] == target) {
            return true;
        } else if (matrix[row][0] > target && row > 0) {
            row -= 1;
        }

        int column = binarySearch(matrix[row], target);

        return matrix[row][column] == target;
    }

    public int binarySearch(int[] data, int target) {
        int leftIndex = 0;
        int rightIndex = data.length - 1;
        int midIndex = (rightIndex - leftIndex) / 2;

        while (leftIndex <= rightIndex) {
            if (data[midIndex] == target) {
                return midIndex;
            } else if (data[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }

            midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        }

        if (midIndex >= data.length) {
            midIndex = data.length - 1;
        }

        return midIndex;
    }

}
