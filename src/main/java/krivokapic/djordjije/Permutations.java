package krivokapic.djordjije;


import java.util.List;
import java.util.ArrayList;


// https://leetcode.com/problems/permutations/description/
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>(), permutations);

        return permutations;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(List.copyOf(permutation));
            return;
        }

        for (int index = 0; index < nums.length; index++) {
            if (visited[index]) {
                continue;
            }

            visited[index] = true;
            permutation.add(nums[index]);
            backtrack(nums, visited, permutation, permutations);

            visited[index] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

}
