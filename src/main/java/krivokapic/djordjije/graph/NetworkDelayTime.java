package krivokapic.djordjije.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class NetworkDelayTime {
    // https://leetcode.com/problems/network-delay-time/description/
    // Time Complexity: O(E logV)
    // Space Complexity: O(E)
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = buildGraph(times);

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        queue.add(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (visited.contains(current[1])) {
                continue;
            }

            visited.add(current[1]);
            t = current[0];

            for (int[] edge : graph.getOrDefault(current[1], List.of())) {
                if (visited.contains(edge[0])) {
                    continue;
                }

                queue.offer(new int[]{current[0] + edge[1], edge[0]});
            }
        }

        return visited.size() == n ? t : -1;
    }


    private Map<Integer, List<int[]>> buildGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, weight});
        }

        return graph;
    }
}
