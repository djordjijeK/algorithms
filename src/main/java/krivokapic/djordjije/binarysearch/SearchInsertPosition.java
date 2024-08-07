package krivokapic.djordjije.binarysearch;


public class SearchInsertPosition {
    // https://leetcode.com/problems/search-insert-position/description/
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int current = nums[mid];

            if (target == current) {
                return mid;
            } else if (target < current) {
                left = left - 1;
            } else {
                right = right + 1;
            }
        }

        return left;
    }
}
