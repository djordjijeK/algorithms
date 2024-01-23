package krivokapic.djordjije;


import java.util.PriorityQueue;


// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> priorityQueue;


    public KthLargest(int k, int[] numbers) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(Math.max(numbers.length, k));

        for (int number : numbers) {
            this.add(number);
        }
    }


    private int add(int number) {
        this.priorityQueue.offer(number);

        if (this.priorityQueue.size() > k) {
            this.priorityQueue.poll();
        }

        return this.priorityQueue.peek();
    }
}
