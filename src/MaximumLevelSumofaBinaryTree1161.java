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
    public int maxLevelSum(TreeNode root) {

        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum=Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int lvl=0, maxLvl=0;
        while(!q.isEmpty())
        {
            int size = q.size();
            sum=0;
            lvl++;
            
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                sum += temp.val;

                if(temp.left != null)
                {
                    q.offer(temp.left);
                }

                if(temp.right != null)
                {
                    q.offer(temp.right);
                }
            }   
            if(sum > ans)
            {
                ans = sum;
                maxLvl = lvl;
            }
        }
        return maxLvl;
    }
}
