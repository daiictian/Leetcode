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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        rec(root,result,sb);
        return result;
    }
    
    private void rec(TreeNode root, List<String> result, StringBuilder sb){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sb.append(String.valueOf(root.val));
           result.add(sb.toString());
            return; 
        }
        sb.append(String.valueOf(root.val)+"->");
        StringBuilder sb2 = new StringBuilder(sb.toString());
        rec(root.left,result,sb);
        rec(root.right,result,sb2);
        
    }
}
