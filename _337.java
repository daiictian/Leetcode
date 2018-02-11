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
    Map<TreeNode,Integer> M = new HashMap<TreeNode,Integer>();
    Map<TreeNode,Boolean> M2 = new HashMap<TreeNode,Boolean>();
    public int rob(TreeNode root) {
        
        return Math.max(rec(root,true),rec(root,false));
    }
    
    private int rec(TreeNode root, boolean canRob){
        if(root == null){
            return 0;
        }
        if(M2.get(root) == null || M2.get(root) != canRob){
            int x = 0;
        if(canRob){
            x =  Math.max(rec(root.left,true)+rec(root.right,true),root.val + rec(root.left,false) + rec(root.right,false)); 
        }else{
            x = rec(root.left,true)+rec(root.right,true);
        }
            M.put(root,x);
            M2.put(root,canRob);
        }
        return M.get(root);
    }
}
