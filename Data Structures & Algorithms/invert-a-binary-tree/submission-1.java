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
    public TreeNode invertTree(TreeNode root) {
        // if(root == null) return null;
        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;

        // invertTree(root.left);
        // invertTree(root.right);
        // return root;
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode tn = queue.poll();
                TreeNode temp = tn.right;
                tn.right = tn.left;
                tn.left = temp;
                if(tn.left != null)
                queue.offer(tn.left);
                if(tn.right != null)
                queue.offer(tn.right);
            }
        }
        return root;
    }
}
