package krivokapic.djordjije.graph.bfs;

import java.util.ArrayList;
import java.util.List;


public class CourseSchedule {

    // https://leetcode.com/problems/course-schedule/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph in adjacency list form
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);

        // calculate in degree for each graph node
        int[] inDegrees = calculateInDegreeForEachGraphNode(graph);

        for (int i = 0; i < numCourses; i++) {
            // find a graph node with 0 in degree (no dependencies / no prerequisites)
            int zeroInDegreeNodeIndex = findNodeWithZeroInDegree(inDegrees);

            // if unable to find such node then we have a cycle in the graph
            if (zeroInDegreeNodeIndex == -1) {
                return false;
            }

            // if we found a node with zero in degree then set its in degree to -1 and reduce in degree
            // of all nodes that have it as a prerequisite by 1
            inDegrees[zeroInDegreeNodeIndex] -= 1;
            for (Integer node : graph.get(zeroInDegreeNodeIndex)) {
                inDegrees[node] -= 1;
            }
        }

        return true;
    }


    List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // each graph node contains a list of graph nodes that depend on it
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        return graph;
    }


    int[] calculateInDegreeForEachGraphNode(List<List<Integer>> graph) {
        int[] inDegreeArray = new int[graph.size()];

        for (List<Integer> nodes : graph) {
            for (Integer node : nodes) {
                inDegreeArray[node] += 1;
            }
        }

        return inDegreeArray;
    }


    int findNodeWithZeroInDegree(int[] inDegrees) {
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                return i;
            }
        }

        return -1;
    }

}
