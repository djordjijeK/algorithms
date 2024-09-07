package core.tree;

public class BalancedBinaryTree {

    // https://leetcode.com/problems/balanced-binary-tree/description/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }


    private int height(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = height(current.left);
        if (left == -1) {
            return -1;
        }

        int right = height(current.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }


}
