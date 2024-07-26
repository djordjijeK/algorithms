package krivokapic.djordjije.easy;


// https://leetcode.com/problems/binary-search/description/
// Time Complexity: O(log(n))
// Space Complexity: O(1)
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int current = nums[mid];

            if (current == target) {
                return mid;
            } else if (target < current) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
