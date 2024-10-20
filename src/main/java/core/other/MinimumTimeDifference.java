package core.other;

import java.util.List;


public class MinimumTimeDifference {
    // https://leetcode.com/problems/minimum-time-difference/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int findMinDifference(List<String> timePoints) {
        // O(1) space complexity
        boolean[] minutes = new boolean[24 * 60];

        // O(n) time complexity
        for (String time : timePoints) {
            int minutesTime = 60 * Integer.parseInt(time.substring(0, 2)) + Integer.parseInt(time.substring(3));
            if (minutes[minutesTime]) {
                return 0;
            }

            minutes[minutesTime] = true;
        }

        int minimumTimeDifference = Integer.MAX_VALUE;
        int leftPointer = -1;
        int rightPointer = -1;
        int firstPointer = -1;

        // O(1) time complexity
        int index = 0;
        while (index < minutes.length) {
            if (!minutes[index]) {
                index += 1;
                continue;
            }

            leftPointer = index;
            if (firstPointer == -1) {
                firstPointer = index;
            }

            do {
                index += 1;
            } while (index < minutes.length && !minutes[index]);

            if (index == minutes.length) {
                break;
            } else {
                rightPointer = index;
            }

            minimumTimeDifference = Math.min(minimumTimeDifference, rightPointer - leftPointer);
        }

        return Math.min(minimumTimeDifference, 1440 - leftPointer + firstPointer);
    }
}
