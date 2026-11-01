class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // Step 1: Insert copy nodes in between original nodes
        while (curr != null) {
            Node next = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        // Step 2: Assign random pointers for copy nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // move to next original
        }

        // Step 3: Separate the two lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node next = curr.next.next;

            // Extract the copy
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            // Restore original list
            curr.next = next;
            curr = next;
        }

        return dummy.next;
    }
}
