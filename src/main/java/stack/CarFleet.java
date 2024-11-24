package stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


public class CarFleet {
    // https://leetcode.com/problems/car-fleet/description/
    // Time Complexity: O(n * log(n))
    // Space Complexity: O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(pairs, Comparator.comparing(pair -> pair.x));
        Stack<Pair> stack = new Stack<>();
        stack.push(pairs[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            Pair currentTop = stack.peek();
            double currentTopTime = (double) (target - currentTop.x) / currentTop.y;

            Pair current = pairs[i];
            double currentTime = (double) (target - current.x) / current.y;

            if (currentTime > currentTopTime) {
                stack.push(current);
            }
        }

        return stack.size();
    }


    record Pair(int x, int y) {

    }
}
