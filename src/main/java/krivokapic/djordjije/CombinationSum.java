package krivokapic.djordjije;


import java.util.List;
import java.util.ArrayList;


// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        search(candidates, target, 0, 0, combination, combinations);

        return combinations;
    }

    private void search(int[] candidates, int target, int candidateIndex, int currentSum, List<Integer> combination, List<List<Integer>> combinations) {
        if (candidateIndex == candidates.length) {
            return;
        }

        if (currentSum == target) {
            combinations.add(List.copyOf(combination));
            return;
        }

        if (currentSum + candidates[candidateIndex] > target) {
            if (candidateIndex + 1 <= candidates.length - 1) {
                search(candidates, target, candidateIndex + 1, currentSum, combination, combinations);
            }

            return;
        }

        currentSum += candidates[candidateIndex];
        combination.add(candidates[candidateIndex]);

        search(candidates, target, candidateIndex, currentSum, combination, combinations);
        currentSum -= combination.remove(combination.size() - 1);
        search(candidates, target, candidateIndex + 1, currentSum, combination, combinations);
    }

}
