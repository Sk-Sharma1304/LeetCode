class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: only 1 node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // track node before slow

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;       // move slow by 1
            fast = fast.next.next;  // move fast by 2
        }

        // slow is now at the middle
        prev.next = slow.next;  

        return head;
    }
}
