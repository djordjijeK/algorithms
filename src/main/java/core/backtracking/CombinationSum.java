package core.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CombinationSum {
    // https://leetcode.com/problems/combination-sum/description/
    // Time Complexity: O(n^target)
    // Space Complexity: O(n^target)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates, 0, target, new LinkedList<>(), 0, combinations);

        return combinations;
    }


    private void backtrack(int[] candidates, int start, int target, LinkedList<Integer> currentCombination, int currentSum, List<List<Integer>> combinations) {
        if (currentSum > target) {
            return;
        }

        if (currentSum == target) {
            combinations.add(List.copyOf(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            backtrack(candidates, i, target, currentCombination, currentSum + candidates[i], combinations);
            currentCombination.removeLast();
        }
    }
}