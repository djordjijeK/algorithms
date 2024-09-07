package training.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PathSumII {
    // https://leetcode.com/problems/path-sum-ii/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, new LinkedList<>(), 0, targetSum, result);

        return result;
    }


    private void backtrack(TreeNode currentNode, List<Integer> currentList, int currentSum, int target, List<List<Integer>> result) {
        if (currentNode == null) {
            return;
        }

        currentList.add(currentNode.val);
        currentSum += currentNode.val;

        if (currentSum == target && currentNode.left == null && currentNode.right == null) {
            result.add(List.copyOf(currentList));
            return;
        }

        if (currentNode.left != null) {
            backtrack(currentNode.left, currentList, currentSum, target, result);
            currentList.removeLast();
        }

        if (currentNode.right != null) {
            backtrack(currentNode.right, currentList, currentSum, target, result);
            currentList.removeLast();
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode() {
        }


        TreeNode(int val) {
            this.val = val;
        }


        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
