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
    public ListNode reverseList(ListNode head) {
        if(head ==null || head.next ==null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null)    return head;
        ListNode head1 = new ListNode(-1);
        head1.next = null;
        ListNode p = head,q;
        while(p != null){
            q = p.next;
            p.next = head1.next;
            head1.next = p;
            p = q;
        }
        return head1.next;
    }
}