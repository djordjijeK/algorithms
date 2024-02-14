package krivokapic.djordjije;

import java.util.HashMap;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        while (right <= s.length() - 1) {
            char character = s.charAt(right);
            Integer index = map.get(character);

            if (index == null) {
                map.put(character, right);
                right++;
                continue;
            }

            int window = right - left;
            if (window > longest) {
                longest = window;
            }

            for (int i = left; i <= index; i++) {
                map.remove(s.charAt(i));
            }

            left = index + 1;
        }

        if (right - left > longest) {
            longest = right - left;
        }

        return longest;
    }

}
