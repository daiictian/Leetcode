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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        rec(root,sum, new ArrayList<Integer>(),result);
        return result;
    }
    
    private void rec(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
        if(root.left == null && root.right == null){
            path.add(root.val);
            if(sum-root.val == 0){
                result.add(new ArrayList<Integer>(path));
            }
            
        }else if(root.left != null && root.right == null){
            path.add(root.val);
            rec(root.left, sum - root.val, path, result);
        
        }else if(root.left == null && root.right != null){
            path.add(root.val);
            rec(root.right, sum - root.val, path, result);
        }else{
            path.add(root.val);
            rec(root.left, sum - root.val, path, result);
            rec(root.right, sum - root.val, path, result);
        }
         if(path.size() != 0)
         path.remove(path.size()-1);
        
       
        
    }
}
