package krivokapic.djordjije.linkedlist;

public class AddTwoNumbers {
    // https://leetcode.com/problems/add-two-numbers/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode current = null;

        boolean carryOver = false;

        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + (carryOver ? 1 : 0);
            carryOver = value > 9;

            ListNode node = new ListNode(value % 10);
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = node;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int value = l1.val + (carryOver ? 1 : 0);
            carryOver = value > 9;

            ListNode node = new ListNode(value % 10);
            current.next = node;
            current = node;

            l1 = l1.next;
        }

        while (l2 != null) {
            int value = l2.val + (carryOver ? 1 : 0);
            carryOver = value > 9;

            ListNode node = new ListNode(value % 10);
            current.next = node;
            current = node;

            l2 = l2.next;
        }

        if (carryOver) {
            current.next = new ListNode(1);
        }

        return head;
    }
}
