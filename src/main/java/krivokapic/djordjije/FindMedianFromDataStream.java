package krivokapic.djordjije;

import java.util.Comparator;
import java.util.PriorityQueue;


// https://leetcode.com/problems/find-median-from-data-stream/description
public class FindMedianFromDataStream {

    class MedianFinder {
        private final PriorityQueue<Integer> leftHeap;
        private final PriorityQueue<Integer> rightHeap;

        public MedianFinder() {
            leftHeap = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
            rightHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            leftHeap.add(num);
            if (leftHeap.size() - rightHeap.size() > 1) {
                int max = leftHeap.poll();
                rightHeap.add(max);
            }

            if (!leftHeap.isEmpty() && !rightHeap.isEmpty() && leftHeap.peek() > rightHeap.peek()) {
                int max = leftHeap.poll();
                int min = rightHeap.poll();

                rightHeap.add(max);
                leftHeap.add(min);
            }
        }

        public double findMedian() {
            if (leftHeap.size() - rightHeap.size() == 1) {
                return leftHeap.peek();
            } else if (rightHeap.size() - leftHeap.size() == 1) {
                return rightHeap.peek();
            }

            return (double) (leftHeap.peek() + rightHeap.peek()) / 2;
        }
    }

}
