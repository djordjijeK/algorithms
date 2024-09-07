package core.arrays;

import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    // https://leetcode.com/problems/two-sum/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> residuals = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (residuals.get(nums[i]) != null) {
                return new int[]{residuals.get(nums[i]), i};
            }

            residuals.put(target - nums[i], i);
        }

        return null;
    }
}
