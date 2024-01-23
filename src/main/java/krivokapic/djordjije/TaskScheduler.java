package krivokapic.djordjije;


import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.PriorityQueue;


// https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n==0) {
            return tasks.length;
        }

        if (tasks.length == 1) {
            return 1;
        }

        Map<Character, Integer> frequencyCount = new HashMap<>();
        for (char task : tasks) {
            frequencyCount.put(task, frequencyCount.getOrDefault(task, 0) - 1);
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(frequencyCount.values());

        Queue<int[]> queue = new ArrayDeque<>();

        int time = 0;
        int result = 0;

        while (!priorityQueue.isEmpty() || !queue.isEmpty()) {
            if (!priorityQueue.isEmpty()) {
                int taskFrequency = priorityQueue.poll();
                if (taskFrequency + 1 < 0) {
                    queue.add(new int[]{taskFrequency + 1, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                    priorityQueue.add(queue.poll()[0]);
            }

            time++;
            result++;
        }

        return result;
    }

}
