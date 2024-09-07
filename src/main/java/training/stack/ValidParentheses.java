package training.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ValidParentheses {
    // https://leetcode.com/problems/valid-parentheses/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isValid(String s) {
        Map<Character, Character> PARENTHESES = new HashMap<>();
        PARENTHESES.put(')', '(');
        PARENTHESES.put('}', '{');
        PARENTHESES.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (PARENTHESES.containsKey(character)) {
                if (stack.isEmpty() || stack.peek() != PARENTHESES.get(character)) {
                    return false;
                }

                stack.pop();
                continue;
            }

            stack.push(character);
        }

        return stack.isEmpty();
    }
}
