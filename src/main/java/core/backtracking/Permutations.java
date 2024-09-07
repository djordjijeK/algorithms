package core.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Permutations {
    // https://leetcode.com/problems/permutations/description/
    // Time Complexity: O(n!)
    // Space Complexity: O(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new LinkedList<>(), permutations);

        return permutations;
    }


    private void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(List.copyOf(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(nums[i]);
                backtrack(nums, visited, permutation, permutations);

                permutation.removeLast();
                visited[i] = false;
            }
        }
    }
}
