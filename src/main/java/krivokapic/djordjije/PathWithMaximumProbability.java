package krivokapic.djordjije;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


// https://leetcode.com/problems/path-with-maximum-probability/description/
public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int startNode, int endNode) {
        Map<Integer, Set<Tuple>> graph = new HashMap<>();
        for (int index = 0; index < edges.length; index++) {
            graph.computeIfAbsent(edges[index][0], node -> new HashSet<>()).add(new Tuple(edges[index][1], succProb[index]));
            graph.computeIfAbsent(edges[index][1], node -> new HashSet<>()).add(new Tuple(edges[index][0], succProb[index]));
        }

        if(!graph.containsKey(startNode) || !graph.containsKey(endNode)) {
            return 0;
        }

        double maxProbability = dijkstra(n, graph, startNode, endNode);
        return maxProbability == Double.MIN_VALUE ? 0 : maxProbability;
    }

    private double dijkstra(int nodes, Map<Integer, Set<Tuple>> graph, int startNode, int endNode) {
        double[] weights = new double[nodes];
        for (int index = 0; index < weights.length; index++) {
            weights[index] = index == startNode ? 1 : Double.MIN_VALUE;
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Tuple::weight).reversed());
        priorityQueue.add(new Tuple(startNode, weights[startNode]));

        while (!priorityQueue.isEmpty()) {
            Tuple tuple = priorityQueue.poll();
            visited.add(tuple.node);

            for (Tuple edge : graph.getOrDefault(tuple.node, Set.of())) {
                if (visited.contains(edge.node)) {
                    continue;
                }

                if (tuple.weight * edge.weight > weights[edge.node]) {
                    weights[edge.node] = tuple.weight * edge.weight;
                    priorityQueue.add(new Tuple(edge.node, weights[edge.node]));
                }
            }
        }

        return weights[endNode];
    }

    private record Tuple(int node, double weight) {}
}
