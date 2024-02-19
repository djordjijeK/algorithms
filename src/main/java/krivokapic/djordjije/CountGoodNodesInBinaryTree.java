package krivokapic.djordjije;


import java.util.Stack;


// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        int result = 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();

            if (pair.node.val >= pair.max) {
                result++;
            }

            if (pair.node.right != null) {
                stack.push(new Pair(pair.node.right,  Math.max(pair.node.right.val, pair.max)));
            }

            if (pair.node.left != null) {
                stack.push(new Pair(pair.node.left,  Math.max(pair.node.left.val, pair.max)));
            }
        }

        return result;
    }

    private record Pair(TreeNode node, int max) {}

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
