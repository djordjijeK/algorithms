package tree;

public class MaximumDepthOfBinaryTree {


    // https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public int maxDepth(TreeNode root) {
        return treeHeight(root);
    }


    public int treeHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }

        return Math.max(treeHeight(current.left) + 1, treeHeight(current.right) + 1);
    }

}
