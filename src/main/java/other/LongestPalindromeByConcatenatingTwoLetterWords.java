package other;

import java.util.Map;
import java.util.HashMap;


public class LongestPalindromeByConcatenatingTwoLetterWords {

    // https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int longestPalindrome(String[] words) {
        int result = 0;
        int sameLettersCount = 0;
        Map<String, Integer> wordToCount = new HashMap<>();

        for (String word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                sameLettersCount +=1;
            }

            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
        }


        for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (key.charAt(0) == key.charAt(1)) {
                result += 2 * (value - (value % 2));
                sameLettersCount -= value - (value % 2);
                continue;
            }

            String searchKey = key.charAt(1) + "" + key.charAt(0);
            int count = Math.min(value, wordToCount.getOrDefault(searchKey, 0));
            result += 4 * count;

            wordToCount.put(key, value - count);
            if (wordToCount.containsKey(searchKey)) {
                wordToCount.put(searchKey, wordToCount.get(searchKey) - count);
            }
        }

        return sameLettersCount > 0 ? result + 2 : result;
    }

}
