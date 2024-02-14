package krivokapic.djordjije;


import java.util.Stack;


// https://leetcode.com/problems/daily-temperatures/description/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int index = 1; index < temperatures.length; index++) {
            if (temperatures[index] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[index] > temperatures[stack.peek()]) {
                    int previousIndex = stack.pop();
                    result[previousIndex] = index - previousIndex;
                }

                stack.push(index);
            } else {
                stack.push(index);
            }
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }

}
