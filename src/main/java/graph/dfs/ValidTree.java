package graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ValidTree {

    // https://neetcode.io/problems/valid-tree
    // Time Complexity: O(nodes + edges)
    // Space Complexity: O(nodes + edges)
    public boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> graph = buildGraph(n, edges);

        Set<Integer> visited = new HashSet<>();
        if (!dfs(graph, 0, -1, visited)) {
            return false;
        }

        return visited.size() == n;
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


    boolean dfs(List<Set<Integer>> graph, int node, int previous, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (neighbor == previous) {
                continue;
            }

            if (!dfs(graph, neighbor, node, visited)) {
                return false;
            }
        }

        return true;
    }

}
