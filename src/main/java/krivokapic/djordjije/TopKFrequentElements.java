package krivokapic.djordjije;


import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;


// https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            counts.put(nums[index], counts.getOrDefault(nums[index], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            }

            return 0;
        });

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry);
            } else if (entry.getValue() > priorityQueue.peek().getValue()) {
                priorityQueue.poll();
                priorityQueue.offer(entry);
            }
        }

        int index = 0;
        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll().getKey();
        }

        return result;
    }

}
