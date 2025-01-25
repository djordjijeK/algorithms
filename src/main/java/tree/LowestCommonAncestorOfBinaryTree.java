package tree;

public class LowestCommonAncestorOfBinaryTree {
    TreeNode result;

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.backtrack(root, p, q);
        return this.result;
    }

    private int backtrack(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }

        int left = this.backtrack(root.left, p, q);
        int right = this.backtrack(root.right, p, q);

        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;

        if (left + mid + right >= 2) {
            this.result = root;
        }

        return (left + mid + right > 0) ? 1 : 0;
    }
}
