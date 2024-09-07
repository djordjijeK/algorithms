package training.daily;


import java.util.HashSet;
import java.util.Set;


public class DeleteNodesFromLinkedListPresentInArray {
    // https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
    // Time Complexity: O(n + m)
    // Space Complexity: O(m)
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode previous = dummy;
        ListNode current = previous.next;
        while (current != null) {
            while (current != null && set.contains(current.val)) {
                previous.next = current.next;
                current = current.next;
            }

            if (current == null || current.next == null) {
                break;
            }

            previous = current;
            current = current.next;
        }

        return dummy.next;
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
