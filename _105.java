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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return b(preorder,inorder,0,0,inorder.length-1);
        
    }
    private TreeNode b(int[] vlr, int[] lvr, int vstart, int lstart, int lend){
        if(vstart > vlr.length-1 || lstart > lend){
            return null;
        }
        TreeNode root = new TreeNode(vlr[vstart]);
        int index = 0;
        for(int i=lstart; i <= lend; i++){
            if(lvr[i] == vlr[vstart]){
                index = i;
                break;
            }
        }
        root.left = b(vlr,lvr,vstart+1,lstart,index-1);
        root.right = b(vlr,lvr,vstart,index+1,lend);
        return root;
    }
}
