package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class KClosestPointsToOrigin {

    // https://leetcode.com/problems/k-closest-points-to-origin/description/
    // Time Complexity: O(n * log(k))
    // Space Complexity: O(k)
    public int[][] kClosest(int[][] points, int k) {
        Queue<double[]> maxHeap = new PriorityQueue<>(k, Comparator.comparingDouble(input -> input[0]));

        for (int index = 0; index < points.length; index++) {
            double distanceToOrigin = calculateDistance(points[index]);
            if (maxHeap.size() < k) {
                maxHeap.add(new double[]{-distanceToOrigin, index});
                continue;
            }

            if (distanceToOrigin < -maxHeap.peek()[0]) {
                maxHeap.poll();
                maxHeap.add(new double[]{-distanceToOrigin, index});
            }
        }

        int[][] result = new int[k][2];
        int index = 0;

        while (!maxHeap.isEmpty()) {
            result[index++] = points[(int) maxHeap.poll()[1]];
        }

        return result;
    }


    double calculateDistance(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }

}
