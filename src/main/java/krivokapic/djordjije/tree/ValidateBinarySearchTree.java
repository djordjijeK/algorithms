package krivokapic.djordjije.tree;

public class ValidateBinarySearchTree {

    // https://leetcode.com/problems/validate-binary-search-tree/description/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }


    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if ((lower != null && node.val <= lower) || (upper != null && node.val >= upper)) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
