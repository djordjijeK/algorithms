package other;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
// Time Complexity: O(n + m)
// Space Complexity: O(n + m)
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char character = p.charAt(i);
            targetMap.put(character, targetMap.getOrDefault(character, 0) + 1);
        }


        int left = 0;
        int right = 0;
        while (left < s.length() && !targetMap.containsKey(s.charAt(left))) {
            left++;
            right++;
        }

        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> currentMap = new HashMap<>();
        int length = 0;

        while (right < s.length()) {
            char rightCharacter = s.charAt(right);

            if (targetMap.containsKey(rightCharacter)) {
                int characterCount = currentMap.getOrDefault(rightCharacter, 0);

                if (characterCount + 1 <= targetMap.get(rightCharacter)) {
                    currentMap.put(rightCharacter, characterCount + 1);
                    length += 1;

                    if (length == p.length()) {
                        list.add(left);

                        char leftCharacter = s.charAt(left);
                        currentMap.put(leftCharacter, currentMap.get(leftCharacter) - 1);
                        left = left + 1;
                        length = length - 1;
                    }

                    right = right + 1;
                } else {
                    char leftCharacter = s.charAt(left);
                    currentMap.put(leftCharacter, currentMap.get(leftCharacter) - 1);
                    left = left + 1;
                    length = length - 1;
                }
            } else {
                while (left < right) {
                    char leftCharacter = s.charAt(left);
                    currentMap.put(leftCharacter, currentMap.get(leftCharacter) - 1);
                    length = length - 1;
                    left += 1;
                }

                right += 1;
                left = right;
            }
        }

        return list;
    }

}
