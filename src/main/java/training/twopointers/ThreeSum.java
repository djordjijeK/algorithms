package training.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    // https://leetcode.com/problems/3sum/description/
    // Time Complexity: O(nlog(n))
    // Space Complexity: O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }

                    left++;
                    right--;
                    continue;
                }

                if (nums[left] + nums[right] + nums[i] > 0) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }

        return result;
    }

}
