package training.stack;

import java.util.Stack;


public class DailyTemperatures {
    // https://leetcode.com/problems/daily-temperatures/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int index = 0; index < temperatures.length; index++) {
            int temperature = temperatures[index];
            while (!stack.isEmpty() && stack.peek()[0] < temperature) {
                int[] pair = stack.pop();
                result[pair[1]] = index - pair[0];
            }

            stack.push(new int[]{temperature, index});
        }

        return result;
    }
}
