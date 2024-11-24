package tree;

public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;


    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public int maxPathSum(TreeNode root) {
        findMaximumPathSum(root);
        return maxSum;
    }


    public int findMaximumPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(findMaximumPathSum(root.left), 0);
        int right = Math.max(findMaximumPathSum(root.right), 0);

        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
