package array;

public class MinimizeMaximumOfArray {
    // https://leetcode.com/problems/minimize-maximum-of-array/
    // Time Complexity: O(n), n - number of array elements
    // Space Complexity: O(1)
    public int minimizeArrayValue(int[] nums) {
        double runningSum = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            runningSum += nums[i];

            if (Math.ceil(runningSum / (i + 1)) > result) {
                result = (int) Math.ceil(runningSum / (i + 1));
            }
        }

        return result;
    }
}
