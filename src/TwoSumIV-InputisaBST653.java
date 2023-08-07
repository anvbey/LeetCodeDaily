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
    List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        helper(root);

        int l = 0, r = list.size()-1;
        while(l < r)
        {
            int left = list.get(l);
            int right = list.get(r);
            int s = left + right;
            if(s == k)
                return true;
            else if(s > k)
            {
                r--;
            }
            else
                l++;
        }

        return false;
    }

    public void helper(TreeNode root)
    {
        if(root == null)
            return ;
        
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
