package training.arrays;

import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate {
    // https://leetcode.com/problems/contains-duplicate/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> data = new HashSet<>();

        for (int num : nums) {
            if (data.contains(num)) {
                return true;
            }

            data.add(num);
        }

        return false;
    }
}
