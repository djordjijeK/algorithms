package krivokapic.djordjije.linkedlist;

public class RemoveNodeFromEndOfLinkedList {
    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode back = head;

        while (n > 0 && front.next != null) {
            front = front.next;
            n--;
        }

        while (front.next != null) {
            front = front.next;
            back = back.next;
        }

        if (back == head && n > 0) {
            head = head.next;
        } else {
            back.next = back.next.next;
        }

        return head;
    }
}
