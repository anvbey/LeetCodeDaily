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
    public int longestZigZag(TreeNode root) {
        
        if(root.left == null && root.right == null)
            return 0;
        
        return Math.max(fun(root.left, false, 1, 1), fun(root.right, true, 1, 1));
    }

    public int fun(TreeNode root, boolean ref, int count, int max)
    {
        if(root == null)
            return max;
        
        max = Math.max(max , count);
        
        if(ref)
        {
            return Math.max(fun(root.left, false, count+1,max), fun(root.right, true, 1,max));
        }
        else
        {
            return Math.max(fun(root.left, false, 1,max), fun(root.right, true, count+1,max));
            // return fun(root.right, !ref, count,max);
        }
    }
}
