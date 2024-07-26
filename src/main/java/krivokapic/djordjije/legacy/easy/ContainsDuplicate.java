package krivokapic.djordjije.easy;

import java.util.HashSet;
import java.util.Set;


// https://leetcode.com/problems/contains-duplicate/description/
// Time Complexity: O(n)
// Space Complexity: O(n)
public class ContainsDuplicate {

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
