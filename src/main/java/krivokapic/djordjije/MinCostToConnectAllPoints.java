package krivokapic.djordjije;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


// https://leetcode.com/problems/min-cost-to-connect-all-points/description/
public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 1) {
            return 0;
        }

        Map<Integer, Set<Edge>> graph = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int distance = manhattanDistance(points[i], points[j]);
                graph.computeIfAbsent(i, k -> new HashSet<>()).add(new Edge(j, distance));
                graph.computeIfAbsent(j, k -> new HashSet<>()).add(new Edge(i, distance));
            }
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        priorityQueue.addAll(graph.get(0));

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        int index = 0;
        Edge[] mst = new Edge[points.length - 1];

        while (!priorityQueue.isEmpty() && index < points.length) {
            Edge edge = priorityQueue.poll();
            if (visited.contains(edge.node)) {
                continue;
            }
            visited.add(edge.node);
            mst[index++] = edge;

            for (Edge e : graph.get(edge.node)) {
                if (visited.contains(e.node)) {
                    continue;
                }

                priorityQueue.add(e);
            }
        }

        return Arrays.stream(mst).mapToInt(Edge::weight).sum();
    }

    private int manhattanDistance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    record Edge(int node, int weight) {}
}
