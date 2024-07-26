package krivokapic.djordjije.legacy.easy;


// https://leetcode.com/problems/valid-palindrome/description/
// Time Complexity: O(n)
// Space Complexity: O(1)
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String input = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
