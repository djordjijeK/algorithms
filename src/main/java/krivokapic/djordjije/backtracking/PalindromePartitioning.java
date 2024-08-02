package krivokapic.djordjije.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PalindromePartitioning {
    // https://leetcode.com/problems/palindrome-partitioning/description/
    // Time Complexity: O(n * 2^n)
    // Space Complexity: O(n * 2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new LinkedList<>(), result);
        return result;
    }


    private void backtrack(String s, int index, LinkedList<String> current, List<List<String>> palindromes) {
        if (index == s.length()) {
            palindromes.add(List.copyOf(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                current.add(substring);
                backtrack(s, i + 1, current, palindromes);
                current.removeLast();
            }
        }
    }


    private boolean isPalindrome(String instance) {
        int left = 0;
        int right = instance.length() - 1;

        while (left < right) {
            if (instance.charAt(left) != instance.charAt(right)) {
                return false;
            }

            left += 1;
            right -= 1;
        }

        return true;
    }
}
