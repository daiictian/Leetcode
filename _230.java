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
    
    public int kthSmallest(TreeNode root, int k) {
        int[] id = new int[1];
        int[] res = new int[1];
        rec(root,id,res,k);
        return res[0];
    }
    
    private void rec(TreeNode root, int[] id, int[] result, int k){
        if(root == null){
            return;
        }
        if(id[0] < k)
        rec(root.left,id,result,k);
        
        id[0]++;
        if(id[0] == k){
            result[0] = root.val;
        }
        if(id[0] < k)
        rec(root.right,id,result,k);
    }
}
