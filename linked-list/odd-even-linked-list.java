class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;  // store start of even list

        while (even != null && even.next != null) {
            odd.next = even.next;   // link odd to next odd
            odd = odd.next;         // move odd forward
            even.next = odd.next;   // link even to next even
            even = even.next;       // move even forward
        }

        odd.next = evenHead; // connect odd list with even list
        return head;
    }
}
