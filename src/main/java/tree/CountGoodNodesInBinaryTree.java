package tree;

public class CountGoodNodesInBinaryTree {

    // https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }


    public int countGoodNodes(TreeNode current, int max) {
        if (current == null) {
            return 0;
        }

        int isGoodNode = 0;
        if (current.val >= max) {
            max = current.val;
            isGoodNode = 1;
        }

        int left = countGoodNodes(current.left, max);
        int right = countGoodNodes(current.right, max);

        return left + right + isGoodNode;
    }
}
