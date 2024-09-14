package _2024.september;

public class LongestSubarrayWithMaximumBitwiseAnd {
    // https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int longestSubarray(int[] nums) {
        int max = 0;
        int result = 0;
        int currentWindowLength = 0;

        for (int num : nums) {
            if (max < num) {
                max = num;
                currentWindowLength = 0;
                result = 0;
            }

            if (max == num) {
                currentWindowLength++;
            } else {
                currentWindowLength = 0;
            }

            result = Math.max(result, currentWindowLength);
        }

        return result;
    }
}
