package _2024.september;

public class SplitLinkedListInParts {
    // https://leetcode.com/problems/split-linked-list-in-parts/description/
    // Time Complexity: O(n)
    // Space Complexity [not counting the output array]: O(1)
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }

        int length = length(head);
        int base = length / k;
        int overflow = length - base * k;

        ListNode current = head;
        ListNode previous = null;

        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int size = base + (overflow > 0 ? 1 : 0);
            overflow = overflow == 0 ? 0 : overflow - 1;

            result[i] = current;
            while (current != null && size > 0) {
                previous = current;
                current = current.next;
                size -= 1;
            }

            previous.next = null;
        }

        return result;
    }


    // O(n): number of nodes in the list
    private int length(ListNode head) {
        int count = 0;

        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }

        return count;
    }


    static class ListNode {
        int val;
        ListNode next;


        public ListNode() {

        }


        public ListNode(int val) {
            this.val = val;
        }


        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
