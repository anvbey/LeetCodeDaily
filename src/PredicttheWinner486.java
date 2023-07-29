class Solution {
    Integer dp[][][];
    public boolean PredictTheWinner(int[] nums) {

        dp = new Integer[nums.length][nums.length][2];
        int s =0;
        for(int i: nums)
            s+= i;
        
        int x= helper(nums, 0, nums.length-1, 0);
        s-= x;
        return (x >= s);
    }

    public int helper(int arr[], int l , int e, int turn)
    {
        if(l > e)
        {
            return 0;
        }

        if(dp[l][e][turn] != null)
            return dp[l][e][turn];
        
        if(turn == 0)
        {
            return dp[l][e][turn] = Math.max(arr[l] + helper(arr, l+1, e, 1), arr[e]+helper(arr, l, e-1, 1));
        } 
        else
            return dp[l][e][turn] = Math.min(helper(arr, l+1, e, 0),helper(arr, l, e-1, 0));
        // return dp[l][e][turn] = Math.max(p1, p2);
    }
}
