package krivokapic.djordjije.legacy;


// https://leetcode.com/problems/longest-palindromic-substring/description/
// Time Complexity: O(n^2)
// Space Complexity: O(1)
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int length = 0;
        String result = "";

        for (int index = 0; index < s.length(); index++) {
            int left = index;
            int right = index;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left >= length) {
                    result = s.substring(left, right + 1);
                    length = right - left + 1;
                }

                left -= 1;
                right += 1;
            }

            left = index;
            right = index + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left >= length) {
                    result = s.substring(left, right + 1);
                    length = right - left + 1;
                }

                left -= 1;
                right += 1;
            }
        }

        return result;
    }

}
