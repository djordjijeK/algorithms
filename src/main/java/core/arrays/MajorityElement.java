package core.arrays;

import java.util.HashMap;
import java.util.Map;


public class MajorityElement {
    // https://leetcode.com/problems/majority-element/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counters = new HashMap<>();

        for (int num : nums) {
            counters.put(num, counters.getOrDefault(num, 0) + 1);
        }

        int resCounter = 0;
        int res = 0;

        for (Map.Entry<Integer, Integer> entry : counters.entrySet()) {
            if (entry.getValue() > resCounter) {
                resCounter = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }
}