package arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class TopKFrequentElements {
    // https://leetcode.com/problems/top-k-frequent-elements/description/
    // Time Complexity: O(n log k)
    // Space Complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                continue;
            }

            if (entry.getValue() > priorityQueue.peek()[1]) {
                priorityQueue.poll();
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] result = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll()[0];
        }

        return result;
    }
}
