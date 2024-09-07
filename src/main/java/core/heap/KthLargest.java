package core.heap;

import java.util.PriorityQueue;
import java.util.Queue;


// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
// Time Complexity: O(n * log(k))
// Space Complexity: O(k)
public class KthLargest {
    private final int k;
    private final Queue<Integer> minHeap;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (this.minHeap.size() < k) {
                this.minHeap.add(num);
            } else if (num > this.minHeap.peek()) {
                this.minHeap.add(num);
                this.minHeap.poll();
            }
        }
    }


    public int add(int val) {
        this.minHeap.add(val);

        if (this.minHeap.size() > k) {
            this.minHeap.poll();
        }

        return this.minHeap.peek();
    }

}
