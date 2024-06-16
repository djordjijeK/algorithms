package krivokapic.djordjije;

import java.util.Arrays;
import java.util.Comparator;


// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
public class MinimumNumberOfArrowsToBurstBallons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]));
        int result = points.length;

        int i = 0;
        while (i < points.length) {
            if (i == points.length - 1) {
                break;
            }

            int[] currentInterval = points[i];
            int j = i + 1;

            while (j < points.length) {
                if (currentInterval[1] < points[j][0]) {
                    break;
                }

                currentInterval[0] = Math.max(currentInterval[0], points[j][0]);
                currentInterval[1] = Math.min(currentInterval[1], points[j][1]);

                result--;
                j++;
            }

            i = j;
        }


        return result;
    }

}
