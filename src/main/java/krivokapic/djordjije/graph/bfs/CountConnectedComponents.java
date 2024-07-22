package krivokapic.djordjije.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class CountConnectedComponents {

    // https://neetcode.io/problems/count-connected-components
    // Time Complexity: O(nodes + edges)
    // Space Complexity: O(nodes + edges)
    public int countComponents(int n, int[][] edges) {
        List<Set<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];

        int numberOfConnectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
                numberOfConnectedComponents++;
            }
        }

        return numberOfConnectedComponents;
    }


    void bfs(List<Set<Integer>> graph, int source, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }
    }


    List<Set<Integer>> buildGraph(int v, int[][] e) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : e) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

}
