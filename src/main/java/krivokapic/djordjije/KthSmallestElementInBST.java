package krivokapic.djordjije;

import java.util.Stack;
import java.util.PriorityQueue;


// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (priorityQueue.size() < k) {
                priorityQueue.add(-node.val);
            } else if (priorityQueue.peek() < -node.val) {
                priorityQueue.poll();
                priorityQueue.add(-node.val);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            System.out.println(priorityQueue);
        }

        return -priorityQueue.poll();
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
