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
        if(head == null)    return null;
        ListNode a = head,b = head;
        for(int i = 0;i < k; i++){
            if(b==null) return head; // 不足 k 个，不需要反转，base case
            b = b.next;
        }
        ListNode newHead = reverse(a,b);//反转前 k 个元素
        a.next = reverseKGroup(b,k);// 递归反转后续链表并连接起来
        return newHead;
    }
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null,cur = a,nxt = a;
        while(cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}