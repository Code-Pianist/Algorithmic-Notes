/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//solution 1：层序遍历
class Solution {
    public Node connect(Node root) {//层序遍历模板
        if(root==null)  return null;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node tmp;
        while(!queue.isEmpty()){
            int size = queue.size();
            tmp = queue.get(0);//注意get方法是LinkedList的
            //连接结点
            for(int i = 1;i < size;i++){//这里循环条件可以使第一个结点跳过，省去了许多操作
                tmp.next = queue.get(i);
                tmp = queue.get(i);
            }
            //入队
            for(int i = 0;i < size;i++){
                tmp = queue.remove();
                if(tmp.left!=null)
                    queue.add(tmp.left);
                if(tmp.right!=null)
                    queue.add(tmp.right);
            }
        }
        return root;
    }
}

class Solution {
    public Node connect(Node root) {
        if(root == null)    return null;
        //将连接根节点的左右子节点转换为将相邻接点连接起来
        connectTwoNode(root.left,root.right);
        return root;
    }
    static void connectTwoNode(Node node1,Node node2){
        if(node1 == null || node2 == null)  return;
        node1.next = node2;

        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node2.left,node2.right);
        connectTwoNode(node1.right,node2.left);
    }
}