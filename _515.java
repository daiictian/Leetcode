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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rec(root,0,result);
        return result;
    }
    
    private void rec(TreeNode root, int level, List<Integer> result){
        if(root == null){
            return;
        }
        
        if(result.size() == 0 || result.size()-1 < level){
            result.add(level,root.val);
        }else if(result.size()-1 >= level){
            result.set(level,Math.max(result.get(level),root.val));
        }
        rec(root.left,level+1,result);
        rec(root.right,level+1,result);
    }
}
