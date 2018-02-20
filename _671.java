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
    public int findSecondMinimumValue(TreeNode root) {
       int x = rec(root);
        if(x == Integer.MAX_VALUE) return -1;
        return x;
    }
    
    private int rec(TreeNode root){
        if(root.left == null || root.right == null) return Integer.MAX_VALUE;
        if(root.val < root.left.val){
            return Math.min(root.left.val, rec(root.right));
        }
        if(root.val < root.right.val){
             return Math.min(root.right.val, rec(root.left));
        }
        return Math.min(rec(root.left), rec(root.right));
    }
}
