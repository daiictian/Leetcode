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
    int sum;
    public int findTilt(TreeNode root) {
        rec(root);
        return sum;
    }
    
    private int rec(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = rec(root.left);
        int right = rec(root.right);
        sum+= Math.abs(left-right);
        return left+right+root.val;
    }
}
