package linkedlist;

public class MergeTwoSortedLists {
    // https://leetcode.com/problems/merge-two-sorted-lists/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }

        return dummy.next;
    }
}