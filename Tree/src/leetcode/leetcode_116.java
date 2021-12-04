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
    public TreeNode invertTree(TreeNode root) {
        //base case
        if(root==null) 
            return null;
        
        //root结点操作：交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //左右子树递归执行
        invertTree(root.left);
        invertTree(root.right);

        //前序遍历框架
        return root;
    }
}