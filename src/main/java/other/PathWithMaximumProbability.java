package other;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class PathWithMaximumProbability {
    // https://leetcode.com/problems/path-with-maximum-probability/description/
    // Time Complexity: O(E log(V))
    // Space Complexity: O(E)
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create an adjacency list to represent the graph
        // Time Complexity: O(E), Space Complexity: O(E)
        Map<Double, Set<double[]>> graph = createGraph(edges, succProb);

        // Priority queue to store nodes with their corresponding probability of reaching that node
        // The queue is ordered by probability in descending order
        // Space Complexity: O(E)
        Queue<double[]> queue = new PriorityQueue<>(Comparator.comparing(input -> input[1], Comparator.reverseOrder()));
        queue.offer(new double[]{start_node, 1});

        // Set to keep track of visited nodes to prevent reprocessing
        // Space Complexity: O(V)
        Set<Double> visited = new HashSet<>();

        double probability = 0;

        // Process each node's neighbors using a priority queue
        // This takes O(E log(V)) time, where E is the number of edges and V is the number of vertices
        while (!queue.isEmpty()) {
            double[] current = queue.poll();
            if (visited.contains(current[0])) {
                continue;
            }

            visited.add(current[0]);
            if (current[0] == end_node) {
                probability = current[1];
                // Early exit since we found the maximum probability path to the end node
                break;
            }

            // Explore neighbors and add them to the priority queue if they haven't been visited
            for (double[] neighbor : graph.getOrDefault(current[0], Set.of())) {
                if (visited.contains(neighbor[0])) {
                    continue;
                }

                queue.offer(new double[]{neighbor[0], current[1] * neighbor[1]});
            }
        }

        return probability;
    }


    private Map<Double, Set<double[]>> createGraph(int[][] edges, double[] probabilities) {
        Map<Double, Set<double[]>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            double u = edges[i][0];
            double v = edges[i][1];
            double weight = probabilities[i];

            graph.computeIfAbsent(u, key -> new HashSet<>()).add(new double[]{v, weight});
            graph.computeIfAbsent(v, key -> new HashSet<>()).add(new double[]{u, weight});
        }

        return graph;
    }
}
