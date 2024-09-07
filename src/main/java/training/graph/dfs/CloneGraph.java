package training.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;


        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }


        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }


        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    // https://leetcode.com/problems/clone-graph/description/
    // Time Complexity: O(nodes + edges)
    // Space Complexity: O(nodes)
    public Node cloneGraph(Node node) {
        // if graph is empty then return null
        if (node == null) {
            return null;
        }

        Node result = null;

        Stack<Node> stack = new Stack<>();
        stack.add(node);

        Set<Integer> visited = new HashSet<>();

        Map<Integer, Node> copiedNodes = new HashMap<>();

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            // there might be a cycle in the graph and we need to skip copying if we already did it once
            if (visited.contains(current.val)) {
                continue;
            }

            // mark the current node from the top of the stack as visited
            visited.add(current.val);

            // get already copied node or create a new one
            Node currentDeepCopy = copiedNodes.computeIfAbsent(current.val, Node::new);
            if (currentDeepCopy.val == 1) {
                result = currentDeepCopy;
            }

            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor.val)) {
                    stack.push(neighbor);
                }

                // deep copy neighbors
                Node neighborDeepCopy = copiedNodes.computeIfAbsent(neighbor.val, Node::new);
                currentDeepCopy.neighbors.add(neighborDeepCopy);
            }
        }

        return result;
    }
}
