package krivokapic.djordjije;


import java.util.Queue;
import java.util.PriorityQueue;


// https://leetcode.com/problems/k-closest-points-to-origin/description/
// Time Complexity: O(nlog(k))
// Space Complexity: O(k)
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        if (points.length == 1) {
            return points;
        }

        Queue<int[]> priorityQueue = new PriorityQueue<>(k, (x, y) -> x[0] - y[0]);

        for(int[] point : points) {
            priorityQueue.offer(new int[]{-distance(point[0], point[1]), point[0], point[1]});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!priorityQueue.isEmpty()) {
            int[] point = priorityQueue.poll();

            result[i][0] = point[1];
            result[i][1] = point[2];
            i++;
        }

        return result;
    }


    private static int distance(int x, int y) {
        return x * x + y * y;
    }
}
