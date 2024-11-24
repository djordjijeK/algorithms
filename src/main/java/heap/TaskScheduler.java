package heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class TaskScheduler {

    // https://leetcode.com/problems/task-scheduler/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(-entry.getValue());
        }

        Queue<Tuple> queue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time = time + 1;

            if (!queue.isEmpty() && time >= queue.peek().y) {
                Tuple tuple = queue.poll();
                maxHeap.add(tuple.x);
            }

            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                Tuple tuple = new Tuple(task + 1, time + n + 1);
                if (tuple.x < 0) {
                    queue.offer(tuple);
                }
            }
        }

        return time;
    }


    record Tuple(int x, int y) {
    }

}
