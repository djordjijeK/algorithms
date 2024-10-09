package _2024.october;

import java.util.Stack;


public class MinimumStringLengthAfterRemovingSubstrings {
    // https://leetcode.com/problems/minimum-string-length-after-removing-substrings/editorial/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i) == 'B' && stack.peek() == 'A') || (s.charAt(i) == 'D' && stack.peek() == 'C')) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        return stack.size();
    }
}
