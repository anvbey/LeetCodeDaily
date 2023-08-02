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
    private int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        height(root);
        return max;
    }

    public int height(TreeNode root)
    {
        if(root == null)
            return -1;
        
        int lH = height(root.left);
        int rH = height(root.right);

        if(max < lH + rH + 2)
            max = lH+ rH + 2;
        
        return Math.max(lH, rH)+1;
    }
}
