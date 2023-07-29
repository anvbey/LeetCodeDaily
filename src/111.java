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
    public int minDepth(TreeNode root) {
       
       return helper(root, 1);
    }

    public static int helper(TreeNode root, int depth)
    {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return depth;
        int left =  helper(root.left, depth+1);
        int right = helper(root.right, depth + 1);
        
        return left != 0 && right != 0?Math.min(left, right): Math.max(left, right);
    }
}
