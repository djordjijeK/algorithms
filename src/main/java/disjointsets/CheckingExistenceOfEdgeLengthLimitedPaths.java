package disjointsets;

import java.util.Arrays;
import java.util.Comparator;


public class CheckingExistenceOfEdgeLengthLimitedPaths {
    // https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/description/
    // Time Complexity: O(E logE + Q logQ)
    // Space Complexity: O(n + Q)
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] queriesWithIndex = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }

        Arrays.sort(edgeList, Comparator.comparingInt(x -> x[2]));
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(x -> x[2]));

        UnionFind unionFind = new UnionFind(n);
        boolean[] results = new boolean[queries.length];

        int j = 0;
        for (int[] query : queriesWithIndex) {
            int u = query[0];
            int v = query[1];
            int limit = query[2];
            int originalIndex = query[3];

            while (j < edgeList.length && edgeList[j][2] < limit) {
                unionFind.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }

            results[originalIndex] = unionFind.connected(u, v);
        }

        return results;
    }


    private static class UnionFind {
        private final int[] parents;
        private final int[] sizes;


        public UnionFind(int n) {
           this.parents = new int[n];
           this.sizes = new int[n];

           for (int i = 0; i < n; i++) {
               parents[i] = i;
               sizes[i] = 1;
           }
        }


        private int find(int x) {
            int root = x;
            while (root != parents[root]) {
                root = parents[root];
            }

            while (x != parents[x]) {
                int temp = parents[x];
                parents[x] = root;
                x = temp;
            }

            return root;
        }


        public void union(int x, int y) {
           int rootX = find(x);
           int rootY = find(y);

           if (rootX == rootY) {
               return;
           }

           int sizeX = sizes[rootX];
           int sizeY = sizes[rootY];

           if (sizeX >= sizeY) {
              parents[rootY] = rootX;
              sizes[rootX] = sizes[rootX] + sizes[rootY];
           } else {
               parents[rootX] = rootY;
               sizes[rootY] = sizes[rootY] + sizes[rootX];
           }
        }

        public boolean connected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            return rootX == rootY;
        }
    }
}
