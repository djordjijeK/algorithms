package core.linkedlist;


public class ReverseLinkedList {
    // https://leetcode.com/problems/reverse-linked-list/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previousNode = head;
        ListNode nextNode = head.next;

        head.next = null;

        while (nextNode != null) {
            ListNode nextNextNode = nextNode.next;
            nextNode.next = previousNode;

            previousNode = nextNode;
            nextNode = nextNextNode;
        }

        return previousNode;
    }
}
