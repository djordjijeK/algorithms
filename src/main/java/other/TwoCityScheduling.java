package other;

import java.util.Arrays;
import java.util.Comparator;


public class TwoCityScheduling {
    // https://leetcode.com/problems/two-city-scheduling/
    // Time Complexity: O(n * log(n))
    // Space Complexity: O(n)
    public int twoCitySchedCost(int[][] costs) {
        int[][] newCosts = new int[costs.length][2];
        for (int index = 0; index < costs.length; index++) {
            newCosts[index] = new int[]{costs[index][1] - costs[index][0], index};
        }

        Arrays.sort(newCosts, Comparator.comparingInt(cost -> cost[0]));

        for (int[] x : newCosts) {
            System.out.println(Arrays.toString(x));
        }

        int minCost = 0;
        for (int index = 0; index < newCosts.length; index++) {
            int[] tuple = newCosts[index];
            minCost += index < newCosts.length / 2 ? costs[tuple[1]][0] : costs[tuple[1]][1];
        }

        return minCost;
    }
}
