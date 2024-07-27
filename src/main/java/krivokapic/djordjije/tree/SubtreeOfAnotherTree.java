package krivokapic.djordjije.tree;

import java.util.LinkedList;
import java.util.Queue;


public class SubtreeOfAnotherTree {

    // https://leetcode.com/problems/subtree-of-another-tree/description/
    // Time Complexity: O(n * m)
    // Space Complexity: O(n)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == subRoot.val && equalTrees(node, subRoot)) {
                return true;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false;
    }


    private boolean equalTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null && root1.val == root2.val) {
            return equalTrees(root1.left, root2.left) && equalTrees(root1.right, root2.right);
        }

        return false;
    }

}
