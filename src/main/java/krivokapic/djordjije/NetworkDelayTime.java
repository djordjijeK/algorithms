package krivokapic.djordjije;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


// https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int nodes, int src) {
        Map<Integer, Set<Tuple>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], key -> new HashSet<>()).add(new Tuple(time[1], time[2]));
        }

        int[] distances = new int[nodes + 1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = i == src ? 0 : Integer.MAX_VALUE;
        }

        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Tuple::weight));
        priorityQueue.add(new Tuple(src, distances[src]));

        Set<Integer> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Tuple tuple = priorityQueue.poll();
            visited.add(tuple.node);

            for (Tuple neighbour : graph.getOrDefault(tuple.node, Set.of())) {
                if (visited.contains(neighbour.node)) {
                    continue;
                }

                if (tuple.weight + neighbour.weight < distances[neighbour.node]) {
                    distances[neighbour.node] = tuple.weight + neighbour.weight;
                    priorityQueue.add(new Tuple(neighbour.node, distances[neighbour.node]));
                }
            }
        }

        int max = 0;
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] > max) {
                max = distances[i];
            }
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    record Tuple(int node, int weight) {}
}
