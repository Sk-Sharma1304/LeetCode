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
    int ans=0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[]dfs(TreeNode root){
        if(root==null)
        return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};

        int left[]=dfs(root.left);
        int right[]=dfs(root.right);
        
        if(left[0]==1 && right[0]==1 && left[2]<root.val && root.val<right[1]){
            int sum=left[3]+right[3]+root.val;
            ans=Math.max(ans,sum);
            return new int[]{1,Math.min(left[1],root.val),Math.max(right[2],root.val),sum};
        }
        return new int[]{0,0,0,0};
    }
}