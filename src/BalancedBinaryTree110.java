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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        return Math.abs(height(root.left, 0) - height(root.right, 0)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node, int h)
    {
        if(node == null)
            return h;
        
        return Math.max(height(node.left, h+1), height(node.right, h+1));
    }
}
