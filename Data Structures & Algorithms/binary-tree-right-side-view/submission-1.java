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

    class Node {
        TreeNode treeNode;
        int layer;
        public Node(TreeNode treeNode, int index){
            this.treeNode = treeNode;
            this.layer = index;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(i == size - 1) res.add(node.val);
            }
        }
        return res;
    }
}
