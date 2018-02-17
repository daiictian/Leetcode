/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();
    TreeNode right;
    public BSTIterator(TreeNode root) {
        TreeNode temp = root;
        while(temp != null){
            st.push(temp);
            temp = temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!st.isEmpty()){
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = null;
        if(right != null){
            TreeNode curr = right;
            while(curr.left != null){
        
                st.push(curr.left);
                curr = curr.left;
            }
            right = null;
        }
            node = st.pop();
            right = node.right;
            if(right != null) st.push(right);
        
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
