package _2024.october;

public class MaximumWidthRamp {
    // https://leetcode.com/problems/maximum-width-ramp/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int maxWidthRamp(int[] nums) {
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
        }

        int left = 0;
        int right = 0;
        int maxRamp = 0;

        while (right < nums.length) {
            while (left < right && nums[left] > rightMax[right]) {
                left++;
            }

            maxRamp = Math.max(maxRamp, right - left);
            right++;
        }

        return maxRamp;
    }
}
