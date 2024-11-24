package slidingwindow;

import java.util.HashSet;
import java.util.Set;


public class LongestSubstringWithoutRepeatingCharacters {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;

        Set<Character> characters = new HashSet<>();
        while (right < s.length()) {
            while (characters.contains(s.charAt(right))) {
                if (right - left > longest) {
                    longest = right - left;
                }

                characters.remove(s.charAt(left));
                left++;
            }

            characters.add(s.charAt(right));
            right++;
        }

        return Math.max(longest, characters.size());
    }
}
