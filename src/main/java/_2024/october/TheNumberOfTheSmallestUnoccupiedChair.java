package _2024.october;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class TheNumberOfTheSmallestUnoccupiedChair {
    // https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
    // Time Complexity: O(n * log(n))
    // Space Complexity: O(n)
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendArrival = times[targetFriend][0];

        Arrays.sort(times, Comparator.comparingInt(ints -> ints[0]));

        Queue<Integer> availableChair = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            availableChair.add(i);
        }

        Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[0]));
        for (int[] interval : times) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= interval[0]) {
                availableChair.add(priorityQueue.poll()[1]);
            }

            if (interval[0] == targetFriendArrival) {
                return availableChair.poll();
            }

            priorityQueue.add(new int[]{interval[1], availableChair.poll()});
        }

        return -1;
    }
}