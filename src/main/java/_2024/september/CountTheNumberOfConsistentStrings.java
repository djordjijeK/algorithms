package _2024.september;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class CountTheNumberOfConsistentStrings {
    // https://leetcode.com/problems/count-the-number-of-consistent-strings/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        return (int) Arrays.stream(words).filter(word -> {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    return false;
                }
            }

            return true;
        }).count();
    }
}
