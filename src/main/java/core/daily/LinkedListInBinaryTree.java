package core.daily;

public class LinkedListInBinaryTree {
    // https://leetcode.com/problems/linked-list-in-binary-tree/
    // Time Complexity: O(n * m)
    // Space Complexity: O(n + m)
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }

        if (dfs(root, head)) {
            return true;
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }


    private boolean dfs(TreeNode node, ListNode current) {
        if (current == null) {
            return true;
        }

        if (node == null) {
            return false;
        }

        boolean result = false;
        if (node.val == current.val) {
            return dfs(node.left, current.next) || dfs(node.right, current.next);
        }

        return result;
    }


    static class ListNode {
        int val;
        ListNode next;


        public ListNode() {

        }


        public ListNode(int val) {
            this.val = val;
        }


        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;


        public TreeNode() {

        }


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
