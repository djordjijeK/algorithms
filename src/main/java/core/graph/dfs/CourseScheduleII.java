package core.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class CourseScheduleII {

    // https://leetcode.com/problems/course-schedule-ii/description/
    // Time Complexity: O(nodes + edges)
    // Space Complexity: O(nodes + edges)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph in adjacency list form
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int node = 0; node < numCourses; node++) {
            if (!visited[node]) {
                if (!dfs(graph, node, visited, path, stack)) {
                    // we have detected the cycle in the graph
                    return new int[]{};
                }
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }


    List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        return graph;
    }


    boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] path, Stack<Integer> stack) {
        // mark node as visited and in the current path
        visited[node] = true;
        path[node] = true;

        for (int neighbor : graph.get(node)) {
            // if neighbor is in path already then we have detected the cycle
            if (path[neighbor]) {
                return false;
            }

            if (!visited[neighbor]) {
                if (!dfs(graph, neighbor, visited, path, stack)) {
                    return false;
                }
            }
        }

        // backtrack on the path variable removing the last node in the path
        path[node] = false;

        // push the node to the stack that contains topologically sorted nodes
        stack.push(node);

        return true;
    }
}
