package krivokapic.djordjije.linkedlist;

import java.util.HashMap;
import java.util.Map;


public class CopyLinkedListWithRandomPointer {
    // https://leetcode.com/problems/copy-list-with-random-pointer/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public Node copyRandomList(Node head) {
        Map<Node, Node> mapping = new HashMap<>();

        Node pointer = head;
        while (pointer != null) {
            Node clone = new Node(pointer.val);
            mapping.put(pointer, clone);

            pointer = pointer.next;
        }

        pointer = head;
        while (pointer != null) {
            Node clone = mapping.get(pointer);
            clone.next = pointer.next != null ? mapping.get(pointer.next) : null;
            clone.random = pointer.random != null ? mapping.get(pointer.random) : null;

            pointer = pointer.next;
        }

        return mapping.get(head);
    }


    public class Node {
        int val;
        Node next;
        Node random;


        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
