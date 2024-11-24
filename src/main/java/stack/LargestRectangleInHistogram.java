package stack;

import java.util.Stack;


public class LargestRectangleInHistogram {
    // https://leetcode.com/problems/largest-rectangle-in-histogram/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(heights[0], 0));

        int max = 0;
        for (int i = 1; i < heights.length; i++) {
            Pair currentPair = new Pair(heights[i], i);

            while (!stack.isEmpty() && stack.peek().value > currentPair.value) {
                Pair stackTop = stack.pop();

                if ((i - stackTop.index) * stackTop.value > max) {
                    max = (i - stackTop.index) * stackTop.value;
                }

                currentPair = new Pair(currentPair.value, stackTop.index);
            }

            stack.push(currentPair);
        }

        while (!stack.isEmpty()) {
            Pair stackTop = stack.pop();

            if ((heights.length - stackTop.index) * stackTop.value > max) {
                max = (heights.length - stackTop.index) * stackTop.value;
            }
        }

        return max;
    }


    record Pair(int value, int index) {
    }
}
