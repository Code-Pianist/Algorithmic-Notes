/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//深拷贝
class Solution {
    Map<Node,Node> canche = new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        if(head == null)    return null;
        while(!canche.containsKey(head)){
            Node newNode = new Node(head.val);
            canche.put(head,newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return canche.get(head);
    }
}