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
    public void inorder(TreeNode root, ArrayList<Integer>list){
        if(root == null)return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return;
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer>list = new ArrayList<>();
        inorder(root, list);
        int ans = 200005;
        int size = list.size();
        if(size == 0 || size == 1)return 0;

        for(int i = 1; i<size; i++){
            ans = Math.min(ans, list.get(i) - list.get(i - 1));
        }
        return ans;
    }
}
