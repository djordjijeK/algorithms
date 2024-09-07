package core.slidingwindow;

import java.util.HashMap;
import java.util.Map;


public class MinimumWindowSubstring {
    // https://leetcode.com/problems/minimum-window-substring/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (int index = 0; index < t.length(); index++) {
            targetMap.put(t.charAt(index), targetMap.getOrDefault(t.charAt(index), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int currentWindowValue = 0;

        int resultLeft = 0;
        int resultRight = Integer.MAX_VALUE - 1;

        while (right < s.length()) {
            char currentCharacter = s.charAt(right);
            if (!targetMap.containsKey(currentCharacter)) {
                right++;
                continue;
            }

            int targetCharacterValue = targetMap.get(currentCharacter);
            int windowCharacterValue = windowMap.getOrDefault(currentCharacter, 0);

            windowCharacterValue += 1;
            windowMap.put(currentCharacter, windowCharacterValue);

            if (windowCharacterValue <= targetCharacterValue) {
                currentWindowValue += 1;
            }

            while (currentWindowValue == t.length()) {
                currentCharacter = s.charAt(left);
                if (!targetMap.containsKey(currentCharacter)) {
                    left++;
                    continue;
                }

                if (right - left + 1 < resultRight - resultLeft + 1) {
                    resultLeft = left;
                    resultRight = right;
                }

                targetCharacterValue = targetMap.get(currentCharacter);
                windowCharacterValue = windowMap.get(currentCharacter);

                windowCharacterValue -= 1;
                windowMap.put(currentCharacter, windowCharacterValue);

                if (windowCharacterValue < targetCharacterValue) {
                    currentWindowValue -= 1;
                }

                left++;
            }

            right++;
        }

        return resultRight != Integer.MAX_VALUE - 1 ? s.substring(resultLeft, resultRight + 1) : "";
    }
}
