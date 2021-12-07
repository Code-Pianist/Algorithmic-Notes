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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p = head,q = head.next;
        ListNode m = q;
        while(p.next!=null && q.next!=null){
            p.next = q.next;

            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = m;
        return head;
    }
}