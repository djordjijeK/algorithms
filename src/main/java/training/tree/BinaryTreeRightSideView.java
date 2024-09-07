package training.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeRightSideView {

    // https://leetcode.com/problems/binary-tree-right-side-view/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();

                if (size == 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                size -= 1;
            }
        }

        return result;
    }

}
