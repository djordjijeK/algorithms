package tree;

import java.util.LinkedList;
import java.util.Queue;


public class CheckCompletenessOfABinaryTree {
    // https://leetcode.com/problems/check-completeness-of-a-binary-tree/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                while (!queue.isEmpty()) {
                    if (queue.poll() != null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
