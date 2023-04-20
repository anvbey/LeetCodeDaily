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
    public int widthOfBinaryTree(TreeNode root) {
        

        Queue<Pair> q = new LinkedList<>();
        int ans=0;

        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();

            int min = q.peek().id;
            int first= 0;
            int last = 0;

            for(int i=0;i<size;i++)
            {
                int currI = q.peek().id- min;
                TreeNode currN= q.peek().node;
                q.poll();
                if(i == 0)
                {
                    first = currI;
                }
                if(i == size -1)
                    last = currI;
                
                if(currN.left != null)
                {
                    q.add(new Pair(currN.left, 2*currI +1));
                }
                
                if(currN.right != null)
                {
                    q.add(new Pair(currN.right, 2*currI +2));
                }
            }

            ans = Math.max(ans, last - first +1);
        }
        return ans;
    }
}

class Pair{

    TreeNode node;
    int id;
    Pair(TreeNode node, int id)
    {
        this.node = node;
        this.id = id;
    }
}
