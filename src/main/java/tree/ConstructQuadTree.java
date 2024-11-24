package tree;

public class ConstructQuadTree {
    // https://leetcode.com/problems/construct-quad-tree/
    // Time Complexity: O(N^2 * log N)
    // Space Complexity: O(N^2)
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }


    private Node buildQuadTree(int[][] grid, int i, int j, int n) {
        if (areAllSame(grid, i, j, n)) {
            return new Node(grid[i][j] == 1, true);
        }

        n = n / 2;

        Node topLeft = buildQuadTree(grid, i, j, n);
        Node topRight = buildQuadTree(grid, i, j + n, n);
        Node bottomLeft = buildQuadTree(grid, i + n, j, n);
        Node bottomRight = buildQuadTree(grid, i + n, j + n, n);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }


    private boolean areAllSame(int[][] grid, int i, int j, int n) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (grid[i][j] != grid[row + i][column + j]) {
                    return false;
                }
            }
        }

        return true;
    }


    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }


        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }


        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
