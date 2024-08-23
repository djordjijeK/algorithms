package krivokapic.djordjije.graph.dfs;

import java.util.List;


public class KeysAndRooms {
    // https://leetcode.com/problems/keys-and-rooms/description/
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nodes = rooms.size();
        boolean[] visited = new boolean[nodes];

        dfs(0, rooms, visited);

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;
    }


    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) {
            return;
        }

        visited[room] = true;

        for (Integer newRoom : rooms.get(room)) {
            dfs(newRoom, rooms, visited);
        }
    }
}
