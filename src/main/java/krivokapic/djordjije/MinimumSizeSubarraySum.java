package krivokapic.djordjije;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;

        int sum = 0;
        int startIndex = 0;

        for (int index = 0; index < nums.length; index++) {
            if (sum + nums[index] < target) {
                sum += nums[index];
                continue;
            }

            sum = sum + nums[index];
            while (sum - nums[startIndex] >= target) {
                sum = sum - nums[startIndex];
                startIndex++;
            }

            if (index - startIndex < result) {
                result = index - startIndex + 1;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
