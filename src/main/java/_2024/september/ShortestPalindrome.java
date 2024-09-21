package _2024.september;

public class ShortestPalindrome {
    // https://leetcode.com/problems/shortest-palindrome/
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }

        int left = 0;
        for (int right = s.length() - 1; right >= 0; right--) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
        }

        if (left == s.length()) {
            return s;
        }

        String nonPalindromicSubstring = s.substring(left);
        StringBuilder reversedNonPalindromicSubstring = new StringBuilder(nonPalindromicSubstring).reverse();

        return reversedNonPalindromicSubstring
                .append(shortestPalindrome(s.substring(0, left)))
                .append(nonPalindromicSubstring)
                .toString();
    }
}
