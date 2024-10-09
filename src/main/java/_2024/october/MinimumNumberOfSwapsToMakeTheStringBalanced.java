package _2024.october;

import java.util.Stack;


public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    // https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        int unbalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '[') {
                stack.push('[');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    unbalanced += 1;
                }
            }
        }

        return (unbalanced + 1) / 2;
    }
}
