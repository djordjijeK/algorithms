package krivokapic.djordjije.medium;


// https://leetcode.com/problems/string-to-integer-atoi/description/
// Time Complexity: O(n)
// Space Complexity: O(1)
public class StringToInteger {

    public int myAtoi(String s) {
        if (s.isBlank()) {
            return 0;
        }

        int result = 0;
        boolean isNegative = false;

        int pointer = 0;
        while (pointer < s.length() && s.charAt(pointer) == ' ') {
            pointer++;
        }

        char character = s.charAt(pointer);
        if (character == '-' || character == '+') {
            isNegative = character == '-';
            pointer = pointer + 1;
        }

        while (pointer < s.length() && Character.isDigit(s.charAt(pointer))) {
            int digit = s.charAt(pointer) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            pointer++;
        }

        return isNegative ? -result : result;
    }

}
