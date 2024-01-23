package krivokapic.djordjije;


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


// https://leetcode.com/problems/subsets/description/
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new LinkedList<>();

        depthFirstSearch(nums, 0, result, subset);

        return result;
    }

    private void depthFirstSearch(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        if (index >= nums.length) {
            result.add(List.copyOf(subset));
            return;
        }

        subset.add(nums[index]);
        depthFirstSearch(nums, index + 1, result, subset);

        subset.remove(subset.size() - 1);
        depthFirstSearch(nums, index + 1, result, subset);
    }

}
