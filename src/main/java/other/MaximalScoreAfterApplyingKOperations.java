package other;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class MaximalScoreAfterApplyingKOperations {
    // https://leetcode.com/problems/maximal-score-after-applying-k-operations/
    // Time Complexity: O(k * log(n) + n * log(n))
    // Space Complexity: O(n)
    public long maxKelements(int[] nums, int k) {
        Queue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (long num : nums) {
            queue.add(num);
        }

        long maxSum = 0;
        for (int i = 0; i < k; i++) {
            long max = queue.poll();
            maxSum += max;

            queue.add((long) Math.ceil(max / 3.0));
        }

        return maxSum;
    }
}
