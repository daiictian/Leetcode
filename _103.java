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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        rec(root,1);
        return result;
    }
    
    private void rec(TreeNode root, int level){
        if(root == null){
            return ;
        }
        if(result.size() < level ){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(root.val);
                result.add(temp);
        } else{
                if(level%2 == 1){
                result.get(level-1).add(root.val);
                }else{
                result.get(level-1).add(0,root.val);
            }
        }  
         rec(root.left,level+1);
         rec(root.right,level+1);
    }
}
