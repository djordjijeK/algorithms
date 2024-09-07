package training.heap;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


// https://leetcode.com/problems/find-median-from-data-stream/description/
class MedianFinder {
    private final Queue<Integer> maxHeap;
    private final Queue<Integer> minHeap;


    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }


    public void addNum(int num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        int maxHeapTop = maxHeap.peek();
        int minHeapTop = minHeap.peek();

        if (maxHeapTop > minHeapTop) {
            maxHeapTop = maxHeap.poll();
            minHeapTop = minHeap.poll();

            maxHeap.add(minHeapTop);
            minHeap.add(maxHeapTop);
        }
    }


    public double findMedian() {
        int elements = maxHeap.size() + minHeap.size();

        if (elements % 2 == 1) {
            return maxHeap.peek();
        }

        return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
    }
}
