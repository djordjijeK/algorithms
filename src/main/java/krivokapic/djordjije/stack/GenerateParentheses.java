package krivokapic.djordjije.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class GenerateParentheses {
    // https://leetcode.com/problems/generate-parentheses/description/
    // Time Complexity: O(4^n)
    // Space Complexity: O(n)
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(0, 0, n, new Stack<>(), list);
        
        return list;
    }


    void backtrack(int opened, int closed, int n, Stack<Character> stack, List<String> result) {
        if (opened == closed && opened == n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char character : stack) {
                stringBuilder.append(character);
            }

            result.add(stringBuilder.toString());
            return;
        }

        if (opened < n) {
            stack.push('(');
            backtrack(opened + 1, closed, n, stack, result);
            stack.pop();
        }

        if (closed < opened) {
            stack.push(')');
            backtrack(opened, closed + 1, n, stack, result);
            stack.pop();
        }
    }
}
