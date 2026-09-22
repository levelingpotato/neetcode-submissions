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
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < queueSize; i++){
                TreeNode curr = queue.removeLast();
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                list.add(curr.val);
                if(left != null){
                    queue.addFirst(left);
                }
                if(right != null){
                    queue.addFirst(right);
                }
            }
            results.add(list);
        }
        return results;
    }
}
