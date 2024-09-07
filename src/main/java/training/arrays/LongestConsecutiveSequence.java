package training.arrays;

import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence {
    // https://leetcode.com/problems/longest-consecutive-sequence/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;
        for (int index = 0; index < nums.length; index++) {
            if (set.contains(nums[index] - 1)) {
                continue;
            }

            int currentLength = 1;
            int num = nums[index] + 1;
            while (set.contains(num)) {
                currentLength++;
                num++;
            }

            if (currentLength > result) {
                result = currentLength;
            }
        }

        return result;
    }
}
