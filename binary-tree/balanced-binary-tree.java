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
    public boolean isBalanced(TreeNode root) {
       return height(root)!=-1;

    }
    private int height(TreeNode root){
        if(root==null)
        return 0;
        int Left= height(root.left);
        int Right=height(root.right);
        if(Left==-1 || Right==-1||Math.abs(Left-Right)>1)
        return -1;
        return Math.max(Left,Right)+1;
    }
}