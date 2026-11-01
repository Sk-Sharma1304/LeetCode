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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1)
        return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode prevGroupEnd=dummy;

        while(true){
            ListNode kth =getkthNode(prevGroupEnd,k);
            if(kth==null)
            break;

            ListNode groupStart=prevGroupEnd.next;
            ListNode nextGroupStart=kth.next;

            reverse (groupStart,kth);

            prevGroupEnd.next=kth;
            groupStart.next=nextGroupStart;

            prevGroupEnd=groupStart;
        }
        return dummy.next;
    }

    private ListNode getkthNode(ListNode curr,int k){
        while(curr!=null && k>0){
            curr=curr.next;
            k--;
        }
        return curr;
    }

    private void reverse (ListNode start,ListNode end){
        ListNode prev=null;
        ListNode curr=start;
        ListNode stop=end.next;

        while(curr!=stop){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
    }
}