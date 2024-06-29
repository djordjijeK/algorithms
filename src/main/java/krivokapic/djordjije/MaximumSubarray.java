package krivokapic.djordjije;

// https://leetcode.com/problems/maximum-subarray/description/
// Time Complexity: O(n)
// Space Complexity: O(1)
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] < nums[i]) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

}
