package core.other;

import java.util.ArrayList;
import java.util.List;


public class NAryTreePreorderTraversal {
    // https://leetcode.com/problems/n-ary-tree-preorder-traversal/
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }


    void preorderTraversal(Node root, List<Integer> result) {
        result.add(root.val);

        for (Node node : root.children) {
            preorderTraversal(node, result);
        }
    }


    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
        }


        public Node(int val) {
            this.val = val;
        }


        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
