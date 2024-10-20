package core.other;

import java.util.Stack;


public class MinimumAddToMakeParenthesesValid {
    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        System.out.println(stack);

        return stack.size();
    }
}
