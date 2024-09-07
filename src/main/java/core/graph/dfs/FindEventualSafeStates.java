package core.graph.dfs;

import java.util.ArrayList;
import java.util.List;


public class FindEventualSafeStates {
    // https://leetcode.com/problems/find-eventual-safe-states/description/
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] safeNodes = new boolean[n];
        boolean[] visited = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(node, graph, visited, safeNodes);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safeNodes[i]) {
                result.add(i);
            }
        }

        return result;
    }


    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] safeNodes) {
        if (safeNodes[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int neighbor = 0; neighbor < graph[node].length; neighbor++) {
            if (!dfs(graph[node][neighbor], graph, visited, safeNodes)) {
                safeNodes[node] = false;
                return false;
            }
        }

        safeNodes[node] = true;
        return true;
    }
}
