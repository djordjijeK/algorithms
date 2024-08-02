package krivokapic.djordjije.tree;

import java.util.HashMap;
import java.util.Map;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int index = 0;


    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            inorderMap.put(inorder[index], index);
        }

        return buildBinaryTree(preorder, inorderMap, 0, inorder.length - 1);
    }


    TreeNode buildBinaryTree(int[] preorder, Map<Integer, Integer> inorderMap, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = preorder[index++];
        TreeNode root = new TreeNode(value);

        root.left = buildBinaryTree(preorder, inorderMap, left, inorderMap.get(value) - 1);
        root.right = buildBinaryTree(preorder, inorderMap, inorderMap.get(value) + 1, right);

        return root;
    }
}
