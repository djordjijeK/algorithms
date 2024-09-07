package training.tree;

public class KthSmallestElementInBST {

    private int count = 0;
    private int result = 0;


    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    // Time Complexity: O(h + k)
    // Space Complexity: O(h)
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }


    private void inorderTraversal(TreeNode current, int k) {
        if (current == null) {
            return;
        }

        inorderTraversal(current.left, k);

        count++;
        if (count == k) {
            result = current.val;
            return;
        }

        inorderTraversal(current.right, k);
    }

}
