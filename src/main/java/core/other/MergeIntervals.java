package core.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


// https://leetcode.com/problems/merge-intervals/description/
// Time Complexity: O(n)
// Space Complexity: O(n)
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] intervalFirst = stack.pop();

            for (int[] interval : overlapIntervals(intervalFirst, intervals[i])) {
                stack.push(interval);
            }
        }


        int[][] result = new int[stack.size()][2];
        int index = 0;

        for (int[] interval : stack) {
            result[index++] = interval;
        }


        return result;
    }


    private int[][] overlapIntervals(int[] intervalFirst, int[] intervalSecond) {
        if (intervalFirst[0] <= intervalSecond[1] && intervalSecond[0] <= intervalFirst[1]) {
            return new int[][]{{Math.min(intervalFirst[0], intervalSecond[0]), Math.max(intervalFirst[1], intervalSecond[1])}};
        }

        return new int[][]{intervalFirst, intervalSecond};
    }

}
