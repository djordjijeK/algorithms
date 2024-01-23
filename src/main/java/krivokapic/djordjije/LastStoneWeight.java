package krivokapic.djordjije;


import java.util.PriorityQueue;


// https://leetcode.com/problems/last-stone-weight/description/
public class LastStoneWeight {

    public int lastStoneWeight(int[] stoneWeights) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stoneWeights.length);

        for (int stoneWeight : stoneWeights) {
            priorityQueue.add(-stoneWeight);
        }

        while (priorityQueue.size() >= 2) {
            int x = -priorityQueue.poll();
            int y = -priorityQueue.poll();

            priorityQueue.add(-Math.abs(x - y));
        }

        return -priorityQueue.peek();
    }

}
