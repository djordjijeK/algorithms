package krivokapic.djordjije.legacy.easy.medium.medium;


import java.util.Arrays;
import java.util.Comparator;


// https://leetcode.com/problems/non-overlapping-intervals/description/
// Time Complexity: O(n*log(n))
// Space Complexity: O(1)
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int left = 0;
        int right = 1;
        int result = 0;

        while (right < intervals.length) {
            if (intervalsOverlap(intervals[left], intervals[right])) {
                result++;
                if (intervals[left][1] > intervals[right][1]) {
                    left = right;
                }
            } else {
                left = right;
            }

            right++;
        }

        return result;
    }


    static boolean intervalsOverlap(int[] left, int[] right) {
        return right[0] < left[1] && left[0] < right[1];
    }

}
