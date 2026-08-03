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

    public boolean isEqual(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 == null){

            if(node1 == null && node2 == null){
                return true;
            }
            return false;
        }

        if(node1.val == node2.val){
            return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
        }

        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode node1 = root;
        
        while(node1 != null){
            boolean check = isEqual(node1, subRoot);
            if(check){
                return true;
            }
            return isSubtree(node1.left, subRoot) || isSubtree(node1.right, subRoot);
        }
        return false;
    }
}
