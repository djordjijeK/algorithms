package krivokapic.djordjije.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class EvaluateReversePolishNotation {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int evalRPN(String[] tokens) {
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!operations.contains(token)) {
                stack.add(Integer.parseInt(token));
                continue;
            }

            int second = stack.pop();
            int first = stack.pop();

            switch (token) {
                case "+" -> stack.push(first + second);
                case "-" -> stack.push(first - second);
                case "*" -> stack.push(first * second);
                case "/" -> stack.push(first / second);
            }
        }

        return stack.pop();
    }
}
