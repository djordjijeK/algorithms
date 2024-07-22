package krivokapic.djordjije.heap;

import java.util.PriorityQueue;
import java.util.Queue;


public class KthLargestElementInAnArray {

    // https://leetcode.com/problems/kth-largest-element-in-an-array/description/
    // Time Complexity: O(n * log(k))
    // Space Complexity: O(k)
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
                continue;
            }

            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }

        return minHeap.poll();
    }

}
