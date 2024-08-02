package krivokapic.djordjije.arrays;

import java.util.HashMap;
import java.util.Map;


public class ValidAnagram {
    // https://leetcode.com/problems/valid-anagram/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            map.put(s.charAt(index), map.getOrDefault(s.charAt(index), 0) + 1);
        }

        for (int index = 0; index < t.length(); index++) {
            if (!map.containsKey(t.charAt(index)) || map.get(t.charAt(index)) <= 0) {
                return false;
            }

            map.put(t.charAt(index), map.get(t.charAt(index)) - 1);
        }

        return true;
    }
}
