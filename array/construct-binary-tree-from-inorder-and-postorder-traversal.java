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
    int postIndex;
    HashMap<Integer,Integer>map=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return construct(postorder,0,inorder.length-1);
    }

    public TreeNode construct(int postorder[],int inStart,int inEnd){
        if(inStart>inEnd)
        return null;
        int rootvalue=postorder[postIndex--];
        TreeNode root=new TreeNode(rootvalue);
        int pos=map.get(rootvalue);
        root.right=construct(postorder,pos+1,inEnd);
        root.left=construct(postorder,inStart,pos-1);
        return root;
    }
}