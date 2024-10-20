package core.other;

import java.util.ArrayList;
import java.util.List;


public class DifferentWaysToAddParentheses {
    // https://leetcode.com/problems/different-ways-to-add-parentheses/
    // Time Complexity: O(n * 2^n)
    // Space Complexity: O(2^n)
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if (expression.isEmpty()) {
            return result;
        }

        if (expression.length() == 1) {
            result.add(Integer.parseInt(expression));
            return result;
        }

        if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            result.add(Integer.parseInt(expression));
            return result;
        }

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (Character.isDigit(character)) {
                continue;
            }

            List<Integer> leftSide = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightSide = diffWaysToCompute(expression.substring(i + 1));

            for (int left : leftSide) {
                for (int right : rightSide) {
                    switch (character) {
                        case '+':
                            result.add(left + right);
                            break;
                        case '-':
                            result.add(left - right);
                            break;
                        case '*':
                            result.add(left * right);
                            break;
                    }
                }
            }
        }

        return result;
    }
}
