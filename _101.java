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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return rec(root.left,root.right);
        
    }
    private boolean rec(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 != null){
            return false;
        }else if(root1 != null && root2 == null){
            return false;
        }else if(root1 == null && root2 == null){
            return true;
        }else {
            return root1.val == root2.val && rec(root1.left,root2.right) && rec(root1.right,root2.left);
        }
    }
    
}
