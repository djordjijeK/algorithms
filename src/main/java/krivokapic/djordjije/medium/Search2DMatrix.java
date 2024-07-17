package krivokapic.djordjije.medium;


// https://leetcode.com/problems/search-a-2d-matrix/description/
// Time Complexity: O(log(m*n))
// Space Complexity: O(1)
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[mid][0] == target) {
                return true;
            }

            if (target > matrix[mid][0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int row = matrix[left == matrix.length ? left - 1 : left][0] < target ? left : left - 1;
        if (row < 0) {
            row = 0;
        } else if (row == matrix.length) {
            row = row - 1;
        }

        left = 0;
        right = matrix[row].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }

            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
