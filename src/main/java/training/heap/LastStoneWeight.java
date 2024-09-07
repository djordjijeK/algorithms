package training.heap;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


public class LastStoneWeight {

    // https://leetcode.com/problems/last-stone-weight/description/
    // Time Complexity: O(n * log(n))
    // Space Complexity: O(n)
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(stones.length);
        Arrays.stream(stones).forEach(stone -> maxHeap.add(-stone));

        while (maxHeap.size() > 1) {
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();

            if (firstStone == secondStone) {
                continue;
            }

            int combinedStone = Math.abs(firstStone - secondStone);
            maxHeap.add(-combinedStone);
        }

        return maxHeap.isEmpty() ? 0 : -maxHeap.peek();
    }

}
