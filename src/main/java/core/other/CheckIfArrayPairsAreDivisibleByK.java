package core.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CheckIfArrayPairsAreDivisibleByK {
    // https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : arr) {
            int key = ((number % k) + k) % k;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int number : arr) {
            int key = ((number % k) + k) % k;

            if (key == 0) {
                if (map.get(key) % 2 == 1) {
                    return false;
                }
            } else if (!Objects.equals(map.get(key), map.get(k - key))) {
                return false;
            }
        }

        return true;
    }
}
