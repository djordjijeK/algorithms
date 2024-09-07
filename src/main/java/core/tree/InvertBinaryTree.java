package core.tree;

import java.util.LinkedList;
import java.util.Queue;


public class InvertBinaryTree {

    // https://leetcode.com/problems/invert-binary-tree/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode left = current.left;
            current.left = current.right;
            current.right = left;

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root;
    }
}
