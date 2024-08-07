package krivokapic.djordjije.arrays;

import java.util.HashMap;
import java.util.Map;


public class LongestPalindrome {
    // https://leetcode.com/problems/longest-palindrome/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int longestPalindrome(String s) {
        int result = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            result += entry.getValue() % 2 == 0 ? entry.getValue() : entry.getValue() - 1;
        }

        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                result += 1;
                break;
            }
        }

        return result;
    }
}
