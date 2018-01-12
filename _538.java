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
    public TreeNode convertBST(TreeNode root) {
        int[] x = new int[1];
        rec(root,x);
        return root;
    }
    
    private void rec(TreeNode root, int[] x){
        if(root == null){
            return ;
        }
        
        rec(root.right,x);
        x[0] += root.val;
        root.val = x[0];
        rec(root.left,x);
    }
}
