/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode fast = temp;
        ListNode slow = temp;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow one step at a time
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the nth node from the end
        slow.next = slow.next.next;

        return temp.next; // Return the head of the updated list
    }
}
