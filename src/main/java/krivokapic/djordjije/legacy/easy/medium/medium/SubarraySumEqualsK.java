package krivokapic.djordjije.legacy.easy.medium.medium;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/subarray-sum-equals-k/description/
// Time Complexity: O(n)
// Space Complexity: O(n)
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;

        Map<Integer, Integer> prefixes = new HashMap<>();
        prefixes.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (prefixes.containsKey(sum - k)) {
                result += prefixes.get(sum - k);
            }

            prefixes.put(sum, prefixes.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}
