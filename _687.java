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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] max = new int[1];
        rec(root,max);
        return max[0];
    }
    
    private int rec(TreeNode root, int[] max){
        
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = rec(root.left,max);
        }
        if(root.right != null){
            right = rec(root.right, max);
        }
      int x= 0;
        int y = 0;
        if(root.left != null && root.val == root.left.val){
           x = left+1;
        }
        if(root.right != null && root.val == root.right.val){
            y = right + 1;
        }
        max[0] = Math.max(max[0],x+y);
        return Math.max(x,y);
    }
}
