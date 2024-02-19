package krivokapic.djordjije;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


// https://leetcode.com/problems/course-schedule-ii/description/
public class CourseSchedule {

    // Note: topological sort with possible cycles
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] solution = new int[numCourses];

        int[] inDegrees = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>(numCourses);

        for (int index = 0; index < numCourses; index++) {
            graph.put(index, new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < inDegrees.length; index++) {
            if (inDegrees[index] == 0) {
                queue.add(index);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            solution[i++] = n;

            for(int neighbor : graph.get(n)) {
               if (inDegrees[neighbor] - 1 == 0) {
                   queue.add(neighbor);
               }

                inDegrees[neighbor] -= 1;
            }
        }

        if (i != numCourses) {
            return new int[]{};
        }

        return solution;
    }

}
