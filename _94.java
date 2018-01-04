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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            
            TreeNode yo = st.peek();
            
            while(yo.left != null && !visited.contains(yo.left)){ 
                yo = yo.left;
               
                st.push(yo);
            }
            yo = st.pop();
            visited.add(yo);
            result.add(yo.val);
            if(yo.right != null){
                st.push(yo.right);
            }   
            
        }
        return result;
        
        
    }
}
