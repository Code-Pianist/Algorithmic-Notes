/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 法一：栈
 法二：反转链表
 法三：逆序数组
 法四：回溯法 */
 class Solution {
     public int[] reversePrint(ListNode head) {
         Stack<ListNode> stack =new Stack<ListNode>();
         ListNode tmp = head;
         while(tmp != null){
             stack.push(tmp);
             tmp = tmp.next;
         }
         int size = stack.size();
         int[] array = new int[size];
        for(int i = 0;i < size;i++){
            array[i] = stack.pop().val;
        }
         return array;
     }
 }

class Solution {
    int res[];
    public int[] reversePrint(ListNode head) {
        reverse(head,0);
        return res;
    }
    public int reverse(ListNode tmp,int len){
        if(tmp == null){
            res = new int[len];
            return 0;
        }
        int index = reverse(tmp.next,len+1);
        res[index] = tmp.val;
        return index+1;
    }
}


