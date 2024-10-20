package core.other;

import java.util.HashMap;
import java.util.Map;


public class UncommonWordsFromTwoSentences {
    // https://leetcode.com/problems/uncommon-words-from-two-sentences/
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m)
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        int uncommonWordsCounter = 0;

        for (String word : s1.split(" ")) {
            int wordCounter = map.getOrDefault(word, 0) + 1;
            uncommonWordsCounter += wordCounter == 1 ? 1 : -1;

            map.put(word, wordCounter);
        }

        for (String word : s2.split(" ")) {
            int wordCounter = map.getOrDefault(word, 0) + 1;
            uncommonWordsCounter += wordCounter == 1 ? 1 : wordCounter == 2 ? -1 : 0;

            map.put(word, wordCounter);
        }

        String[] result = new String[uncommonWordsCounter];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 1) {
                continue;
            }

            result[--uncommonWordsCounter] = entry.getKey();
        }

        return result;
    }
}
