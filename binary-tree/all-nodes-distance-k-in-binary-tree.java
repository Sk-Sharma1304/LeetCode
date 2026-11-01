/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode>parentMap=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        markParents(root,null);
        Queue<TreeNode>queue=new LinkedList<>();
        HashSet<TreeNode>visited=new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int distance=0;
        while(!queue.isEmpty()){
            if(distance==k)
            break;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode current=queue.poll();
                if(current.left!=null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if(current.right!=null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right);
                }
                if(parentMap.get(current)!=null && !visited.contains(parentMap.get(current))){
                    queue.offer(parentMap.get(current));
                    visited.add(parentMap.get(current));
                }
            }
            distance++;
        }
        List<Integer> answer=new ArrayList<>();
        while(!queue.isEmpty()){
            answer.add(queue.poll().val);
        }
        return answer;
    }
    private void markParents(TreeNode node,TreeNode parent){
        if(node==null)
        return;
        parentMap.put(node,parent);
        markParents(node.left,node);
        markParents(node.right,node);
    }
}