/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorderSerialize(root,sb);
        return sb.toString();
    }
    private void preorderSerialize(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        preorderSerialize(node.left,sb);
        preorderSerialize(node.right,sb);
    }

    int index=0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[]=data.split(",");
        index=0;
        return preorderDeserialize(arr);
    }
    private TreeNode preorderDeserialize(String arr[]){
        if(arr[index].equals("N")){
            index++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(arr[index]));
        index++;
        node.left=preorderDeserialize(arr);
        node.right=preorderDeserialize(arr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));