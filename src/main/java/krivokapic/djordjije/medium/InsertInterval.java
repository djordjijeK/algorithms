package krivokapic.djordjije.medium;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/insert-interval/description/
// Time Complexity: O(n)
// Space Complexity: O(n)
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = mergeIntervals(intervals, newInterval);

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = new int[] {list.get(i).get(0), list.get(i).get(1)};
        }

        return result;
    }

    List<List<Integer>> mergeIntervals(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                list.add(List.of(newInterval[0], newInterval[1]));
                for (int j = i; j < intervals.length; j++) {
                    list.add(List.of(intervals[j][0], intervals[j][1]));
                }

                return list;
            } else if (intervals[i][1] < newInterval[0]) {
                list.add(List.of(intervals[i][0], intervals[i][1]));
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        list.add(List.of(newInterval[0], newInterval[1]));
        return list;
    }

}
