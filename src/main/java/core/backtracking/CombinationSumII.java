package core.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CombinationSumII {
    // https://leetcode.com/problems/combination-sum-ii/description/
    // Time Complexity: ??
    // Space Complexity: ??
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, new LinkedList<>(), 0, combinations);

        return combinations;
    }


    private void backtrack(int[] candidates, int currentIndex, int target, LinkedList<Integer> currentCombination, int currentSum, List<List<Integer>> combinations) {
        if (currentSum > target) {
            return;
        }

        if (currentSum == target) {
            combinations.add(List.copyOf(currentCombination));
            return;
        }

        for (int index = currentIndex; index < candidates.length; index++) {
            if (index > currentIndex && candidates[index - 1] == candidates[index]) {
                continue;
            }

            currentCombination.add(candidates[index]);
            currentSum += candidates[index];

            backtrack(candidates, index + 1, target, currentCombination, currentSum, combinations);

            currentSum -= candidates[index];
            currentCombination.removeLast();
        }
    }
}
