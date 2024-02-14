package krivokapic.djordjije;


// https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode head = null;
        ListNode current = null;

        while (l1 != null || l2 != null) {
            int sum1 = l1 != null ? l1.val : 0;
            int sum2 = l2 != null ? l2.val : 0;

            int sum = carry ? sum1 + sum2 + 1 : sum1 + sum2;
            carry = sum >= 10;

            if (head == null) {
                head = new ListNode(sum % 10);
                current = head;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry) {
            current.next = new ListNode(1);
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;


        ListNode() {}


        ListNode(int val) {
            this.val = val;
        }


        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
