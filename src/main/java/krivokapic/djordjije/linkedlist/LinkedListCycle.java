package krivokapic.djordjije.linkedlist;

public class LinkedListCycle {
    // https://leetcode.com/problems/linked-list-cycle/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
