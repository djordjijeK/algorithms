package binarysearch;

public class FindPeakElement {
    // https://leetcode.com/problems/find-peak-element/
    // Time Complexity: O(log (n))
    // Space Complexity: O(1)
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (
                    (mid == 0 && nums[0] > nums[1]) ||
                            (mid == nums.length - 1 && nums[nums.length - 1] > nums[nums.length - 2]) ||
                            ((mid - 1 >= 0 && nums[mid] > nums[mid - 1]) && (mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]))
            ) {
                return mid;
            }

            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
