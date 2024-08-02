package krivokapic.djordjije.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class SubsetsII {
    // https://leetcode.com/problems/subsets-ii/description/
    // Time Complexity: O(n * 2^n)
    // Space Complexity: O(n * 2^n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, 0, new LinkedList<>(), result);

        return result;
    }


    private void backtrack(int[] nums, int currentIndex, LinkedList<Integer> subset, List<List<Integer>> subsets) {
        for (int index = currentIndex; index < nums.length; index++) {
            if (index > currentIndex && nums[index] == nums[index - 1]) {
                continue;
            }

            subset.add(nums[index]);
            backtrack(nums, index + 1, subset, subsets);
            subset.removeLast();
        }

        subsets.add(List.copyOf(subset));
    }
}
