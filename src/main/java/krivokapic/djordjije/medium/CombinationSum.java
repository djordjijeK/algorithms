package krivokapic.djordjije.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// https://leetcode.com/problems/combination-sum/description/
// Time Complexity: O(n^target)
// Space Complexity: O(target)
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new LinkedList<>(), result);

        return result;
    }

    void backtrack(int[] candidates, int target, int index, int currentSum, List<Integer> combination, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(List.copyOf(combination));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target, i, currentSum + candidates[i], combination, result);

            combination.remove(combination.size() - 1);
        }
    }

}
