package arrays;

import java.util.List;
import java.util.TreeSet;


public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {

    // https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/
    // Time Complexity: O(n*log(n))
    // Space Complexity: O(n)
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        int result = Integer.MAX_VALUE;

        for (int index = 0; index < nums.size(); index++) {
            if (index >= x) {
                treeSet.add(nums.get(index - x));
            }

            if (!treeSet.isEmpty()) {
                int number = nums.get(index);

                Integer floor = treeSet.floor(number);
                if (floor != null) {
                    result = Math.min(result, Math.abs(number - floor));
                }

                Integer ceil = treeSet.ceiling(number);
                if (ceil != null) {
                    result = Math.min(result, Math.abs(number - ceil));
                }
            }
        }

        return result;
    }

}
