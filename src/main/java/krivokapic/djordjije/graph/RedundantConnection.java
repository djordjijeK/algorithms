package krivokapic.djordjije.graph;

public class RedundantConnection {

    // https://leetcode.com/problems/redundant-connection/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;

        int[] parents = new int[nodes + 1];
        int[] ranks = new int[nodes + 1];
        for (int i = 0; i < nodes + 1; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int index = 0;
        while (union(parents, ranks, edges[index][0], edges[index][1])) {
            index++;
        }

        return edges[index];
    }


    int find(int[] parents, int node) {
        if (parents[node] != node) {
            parents[node] = find(parents, parents[node]);
        }

        return parents[node];
    }


    boolean union(int[] parents, int[] ranks, int x, int y) {
        int root1 = find(parents, x);
        int root2 = find(parents, y);

        if (root1 == root2) {
            return false;
        }

        int rank1 = ranks[root1];
        int rank2 = ranks[root2];

        if (rank1 >= rank2) {
            parents[root2] = root1;
            ranks[root1] = rank1 + rank2;
        } else {
            parents[root1] = root2;
            ranks[root2] = rank1 + rank2;
        }

        return true;
    }
}
