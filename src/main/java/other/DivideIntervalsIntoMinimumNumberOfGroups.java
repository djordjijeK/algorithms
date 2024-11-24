package other;

import java.util.Arrays;


public class DivideIntervalsIntoMinimumNumberOfGroups {
    // https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
    // Time Complexity: O(n * log(n))
    // Space Complexity: O(n)
    public int minGroups(int[][] intervals) {
        int[][] events = new int[2 * intervals.length][2];

        int index = 0;
        for (int[] interval : intervals) {
            events[index++] = new int[]{interval[0], 1};
            events[index++] = new int[]{interval[1] + 1, -1};
        }

        Arrays.sort(events, (first, second) -> {
            if (first[0] == second[0]) {
                return Integer.compare(first[1], second[1]);
            }

            return Integer.compare(first[0], second[0]);
        });

        int concurrency = 0;
        int maxConcurrency = 0;
        for (int[] event : events) {
            concurrency += event[1] == 1 ? 1 : -1;
            maxConcurrency = Math.max(maxConcurrency, concurrency);
        }

        return maxConcurrency;
    }
}
