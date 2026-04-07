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
    HashMap<Integer, Integer> map = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder,  0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int index, int[] inorder
    , int left, int right){
        if(left > right) return null;
        int r_val = preorder[index];
        int i = map.get(r_val);
        TreeNode root = new TreeNode(r_val);
        int leftSize = i - left;
        root.left = build(preorder, index+1, inorder, left, i - 1);
        root.right = build(preorder, index + leftSize + 1, inorder, i + 1, right);
        return root;
    }
}
