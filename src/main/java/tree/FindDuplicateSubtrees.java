package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindDuplicateSubtrees {
    // https://leetcode.com/problems/find-duplicate-subtrees/
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> hashMap = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();

        dfs(root, hashMap, result);

        return result;
    }


    private String dfs(TreeNode root, Map<String, Integer> hashMap, List<TreeNode> results) {
        if (root == null) {
            return "NULL";
        }

        String subtree = String.format("%s;%s;%s", root.val, dfs(root.left, hashMap, results), dfs(root.right, hashMap, results));
        if (hashMap.getOrDefault(subtree, 0) == 1) {
            results.add(root);
        }

        hashMap.put(subtree, hashMap.getOrDefault(subtree, 0) + 1);

        return subtree;
    }
}
