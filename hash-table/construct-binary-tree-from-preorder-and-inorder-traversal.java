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
    int preIndex=0;
    HashMap<Integer,Integer>map= new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return construct(preorder,0,inorder.length-1);
    }

    public TreeNode construct(int[]preOrder,int inStart, int inEnd){
        if(inStart > inEnd)
        return null;

        int rootvalue=preOrder[preIndex++];
        TreeNode root=new TreeNode(rootvalue);
        int pos=map.get(rootvalue);
        root.left=construct(preOrder,inStart,pos-1);
        root.right=construct(preOrder,pos+1,inEnd);
        return root;
    }
}