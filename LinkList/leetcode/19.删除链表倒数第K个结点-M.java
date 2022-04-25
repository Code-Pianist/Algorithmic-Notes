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
        //设置虚拟头结点
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        //找出倒数k+1结点
        ListNode x = findNThFromEnd(tmp,n+1);
        x.next = x.next.next;
        return tmp.next;
    }

    private ListNode findNThFromEnd(ListNode tmp,int k){
        ListNode p1 = tmp,p2 = tmp;
        for(int i = 0;i < k;i++){//k-1
            p1 = p1.next;
        }
        while(p1!=null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}