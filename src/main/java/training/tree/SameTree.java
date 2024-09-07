package training.tree;

public class SameTree {

    // https://leetcode.com/problems/same-tree/description/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

}
