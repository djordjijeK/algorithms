package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Subsets {
    // https://leetcode.com/problems/subsets/description/
    // Time Complexity: O(n * 2^n)
    // Space Complexity: O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new LinkedList<>(), result);

        return result;
    }


    public void backtrack(int[] nums, int index, LinkedList<Integer> current, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.removeLast();
        }

        result.add(List.copyOf(current));
    }
}
