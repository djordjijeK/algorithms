package krivokapic.djordjije.legacy.easy.medium.medium;


// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// Time Complexity: O(log(n))
// Space Complexity: O(1)
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

}
