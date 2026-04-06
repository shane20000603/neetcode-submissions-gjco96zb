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
    public boolean isValidBST(TreeNode root) {
        return rec(root, -1000, 1000);
    }

    private boolean rec(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val > min && root.val < max){
            return rec(root.left, min, root.val) && rec(root.right, root.val, max);
        } else return false;
    }

}
