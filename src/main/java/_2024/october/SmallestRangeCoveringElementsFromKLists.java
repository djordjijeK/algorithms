package _2024.october;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class SmallestRangeCoveringElementsFromKLists {
    // https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
    // Time Complexity: O(n log k)
    // Space Complexity: O(k)
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n[0]));
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            priorityQueue.add(new int[]{nums.get(i).get(0), i, 0});
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }

        while (priorityQueue.size() == nums.size()) {
            int[] tuple = priorityQueue.poll();

            if (maxValue - tuple[0] < rangeEnd - rangeStart) {
                rangeStart = tuple[0];
                rangeEnd = maxValue;
            }

            if (tuple[2] + 1 < nums.get(tuple[1]).size()) {
                int value = nums.get(tuple[1]).get(tuple[2] + 1);
                priorityQueue.add(new int[]{value, tuple[1], tuple[2] + 1});
                maxValue = Math.max(maxValue, value);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
