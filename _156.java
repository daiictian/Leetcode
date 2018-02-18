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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        left.push(root);
        TreeNode curr = root;
        while(curr.left != null){
            left.push(curr.left);
            right.push(curr.right);
            curr = curr.left;
        }
        TreeNode newRoot = left.pop();
        TreeNode yo = null;
        yo = newRoot;
        
        while(!left.isEmpty() && !right.isEmpty()){
                TreeNode r = right.pop();
                 TreeNode l = left.pop();
             if(r != null){
                r.left = null;
                r.right = null;
             }
                l.left = null;
                l.right = null;
                newRoot.right = l;
               newRoot.left = r;
               
            
             newRoot = newRoot.right;
        }
        return yo;
    }
    
}
