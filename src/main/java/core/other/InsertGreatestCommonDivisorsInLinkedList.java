package core.other;

public class InsertGreatestCommonDivisorsInLinkedList {
    // https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
    // Time Complexity: O(n * log(min(a, b))
    // Space Complexity: O(1)
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        ListNode next = head.next;

        while (next != null) {
            int gcd = greatestCommonDivisor(current.val, next.val);
            ListNode newNode = new ListNode(gcd);

            current.next = newNode;
            newNode.next = next;

            current = next;
            next = current.next;
        }

        return head;
    }


    private int greatestCommonDivisor(int x, int y) {
        if (x == 0) {
            return y;
        }

        return greatestCommonDivisor(y % x, x);
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
