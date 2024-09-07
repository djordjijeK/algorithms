package core.tree;

public class LowestCommonAncestorOfBinarySearchTree {

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
    // Time Complexity: O(h)
    // Space Complexity: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        return root;
    }

}
