package tree;

public class DiameterOfBinaryTree {

    private int diameter = 0;
    

    // https://leetcode.com/problems/diameter-of-binary-tree/description/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }


    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
