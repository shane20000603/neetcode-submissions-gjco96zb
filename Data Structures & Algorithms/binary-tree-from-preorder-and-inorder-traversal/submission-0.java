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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        System.out.println(root.val);
        int pivot = start;
        for(int i = start; i <= end; i++){
            if(inorder[i] == root.val){
                pivot = i;
                 System.out.println("pivot: "+ root.val);
                 break;
            }
           
        }
        System.out.println("start: "+ start + ", end: " + (pivot - 1));
        root.left = dfs(preorder, inorder, start, pivot - 1);
        System.out.println("start: "+ (pivot + 1) + ", end: " + end);
        root.right = dfs(preorder, inorder, pivot + 1, end);
        return root;
    }
}
