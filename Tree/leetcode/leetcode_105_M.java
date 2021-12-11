/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    public static TreeNode build(int[] preorder,int preStart,int preEnd,
                                 int[] inorder,int inStart,int inEnd)
    {
        if(preStart > preEnd)
            return null;

        //前序遍历第一个结点就是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //从中序中找根节点索引，划分为左右子树
        int index = 0;
        for(int i = inStart;i <= inEnd;i++){
            if(inorder[i]==rootVal){
                index = i;
                break;
            }
        }

        //此时left的preEnd和right的inStart可以根据leftSize计算
        int leftSize = index - inStart;
        root.left = build(preorder,preStart+1,preStart+leftSize,
                inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,
                inorder,index+1,inEnd);

        return root;

    }
}