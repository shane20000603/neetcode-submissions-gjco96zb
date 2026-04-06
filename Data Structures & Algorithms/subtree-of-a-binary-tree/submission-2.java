/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String r = treeToString(root);
        System.out.println(r);
        String sub = treeToString(subRoot);
        System.out.println(sub);
        return r.contains(sub);
    }

    private String treeToString(TreeNode root){
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            sb.append(node.val);
            if(node.right != null)
            stack.push(node.right);
            else sb.append('#');
            if(node.left != null)
            stack.push(node.left);
            else sb.append('#');
        }
        return sb.toString();
    }
}
