package tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class ClosestLeafInABinaryTree {

    TreeNode startNode;

    // https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> nodeToParentMapping = buildNodeToParentMapping(root, k);
        return bfs(startNode, nodeToParentMapping);
    }

    private int bfs(TreeNode startNode, Map<TreeNode, TreeNode> nodeToParentMapping) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(startNode);

        Set<TreeNode> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null && current.right == null) {
                return current.val;
            }

            TreeNode parent = nodeToParentMapping.get(current);
            if (parent != null && !visited.contains(parent)) {
                queue.add(parent);
                visited.add(parent);
            }

            if (current.left != null && !visited.contains(current.left)) {
                queue.add(current.left);
                visited.add(current.left);
            }

            if (current.right != null && !visited.contains(current.right)) {
                queue.add(current.right);
                visited.add(current.right);
            }
        }

        return -1;
    }

    private Map<TreeNode, TreeNode> buildNodeToParentMapping(TreeNode root, int searchValue) {
        Map<TreeNode, TreeNode> nodeToParentMapping = new HashMap<>();
        nodeToParentMapping.put(root, null);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.val == searchValue) {
                startNode = current;
            }

            if (current.left != null) {
                nodeToParentMapping.put(current.left, current);
                stack.push(current.left);
            }

            if (current.right != null) {
                nodeToParentMapping.put(current.right, current);
                stack.push(current.right);
            }
        }

        return nodeToParentMapping;
    }

}
