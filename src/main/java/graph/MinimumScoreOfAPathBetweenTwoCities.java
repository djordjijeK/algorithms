package graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class MinimumScoreOfAPathBetweenTwoCities {
    // https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
    // Time Complexity: O(vertices + edges)
    // Space Complexity: O(vertices + edges)
    public int minScore(int n, int[][] roads) {
        int result = Integer.MAX_VALUE;

        Map<Integer, Set<int[]>> graph = new HashMap<>();
        for (int[] edge : roads) {
            graph.computeIfAbsent(edge[0], key -> new HashSet<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], key -> new HashSet<>()).add(new int[]{edge[0], edge[2]});
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.addAll(graph.get(1));

        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            visited.add(edge[0]);

            result = Math.min(result, edge[1]);

            for (int[] neighbor : graph.get(edge[0])) {
                if (visited.contains(neighbor[0])) {
                    continue;
                }

                queue.add(neighbor);
            }
        }

        return result;
    }
}
