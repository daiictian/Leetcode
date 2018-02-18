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
     Map<Integer,List<Integer>> M = new LinkedHashMap<Integer,List<Integer>>();
        Map<TreeNode,Integer> M2 = new HashMap<TreeNode,Integer>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        int h = height(root);
       
        for(int i=1; i <= h; i++){
            M.put(i, new ArrayList<Integer>());
        }
        rec(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> list : M.values()){
            result.add(list);
        }
        
        return result;
        
    }
    
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int x =  1 + Math.max(height(root.left),height(root.right));
        M2.put(root,x);
        return x;
    }
    
    private void rec(TreeNode root){
        if(root == null){
            return;
        }
        rec(root.left);
        M.get(M2.get(root)).add(root.val);
        rec(root.right);
    }
    
    
}
