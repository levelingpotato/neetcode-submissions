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
    public List<List<Integer>> levelOrder(TreeNode root) {
    
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        Deque<TreeNode> currNodes = new ArrayDeque<>();
        currNodes.offer(root);
        while(!currNodes.isEmpty()){
            ArrayList<Integer> result = new ArrayList<>();
            Deque<TreeNode> loopNodes = new ArrayDeque<>();
            while(!currNodes.isEmpty()){
                TreeNode currNode = currNodes.poll();
                result.add(currNode.val);
                if(currNode.left != null){
                    loopNodes.offer(currNode.left);
                }
                if(currNode.right != null){
                    loopNodes.offer(currNode.right);
                }
            }
            results.add(result);
            currNodes = loopNodes;
        }

        return results;


    }
}
