/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("A,");
        rec(root,sb);
        return sb.toString().substring(0,sb.toString().length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] yy = data.split(",");
        int[] x = new int[1];
        x[0]++;
        return des(yy,x);
    }
    
    private void rec(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null");
            sb.append(",");
            return;
        }
        sb.append(String.valueOf(root.val));
        sb.append(",");
        rec(root.left,sb);
        rec(root.right,sb);
    }
    
    private TreeNode des(String[] nodes, int[] id ){
        if(nodes[id[0]].equals("null")){
            id[0]++;
            return null;
        }
        int x = id[0];
        TreeNode node = new TreeNode(Integer.parseInt(nodes[x]));
        id[0]++;
        node.left = des(nodes,id);
        node.right = des(nodes,id);
        return node;
        
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
