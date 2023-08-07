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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++)
        {
            helper(root, preorder[i]);
        }

        return root;
    }

    public void helper(TreeNode root, int key)
    {
        if(root.val > key)
        {
            if(root.left == null)
            {
                root.left = new TreeNode(key);
                return ;
            }
            else
                helper(root.left, key);
        }
        else
        {
            if(root.right == null)
            {
                root.right = new TreeNode(key);
                return ;
            }
            else
                helper(root.right , key);
        }
    }
}
