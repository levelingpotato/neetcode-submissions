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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int count = 1;

    

        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);

        if(rightDepth >= leftDepth){
            return count + rightDepth;
        } else {
            return count + leftDepth;
        }
        
    }
}
