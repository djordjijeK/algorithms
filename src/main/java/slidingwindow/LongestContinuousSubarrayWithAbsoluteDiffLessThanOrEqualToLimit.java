package slidingwindow;

import java.util.ArrayDeque;


public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    // https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        ArrayDeque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int maxSubarray = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }

                left++;
            }

            maxSubarray = Math.max(maxSubarray, right - left + 1);
        }

        return maxSubarray;
    }
}
