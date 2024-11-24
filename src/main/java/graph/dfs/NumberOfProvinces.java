package graph.dfs;


public class NumberOfProvinces {
    // https://leetcode.com/problems/number-of-provinces/description/
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int provinces = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, n, visited);
                provinces = provinces + 1;
            }
        }

        return provinces;
    }


    private void dfs(int city, int[][] isConnected, int n, boolean[] visited) {
        visited[city] = true;

        for (int i = 0; i < n; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(i, isConnected, n, visited);
            }
        }
    }
}
