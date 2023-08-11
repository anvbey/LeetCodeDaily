class Solution {
    Integer dp[][];
    public int change(int amount, int[] coins) {
        
        dp = new Integer[coins.length][amount+1];
        return helper(amount, coins, 0);
    }

    public int helper(int amount, int arr[], int i)
    {
        //base condition       
        if(amount == 0)
            return 1;
        if(i == arr.length)
            return 0;
        
        if(dp[i][amount] != null)
            return dp[i][amount];
        int pick= 0;

        if(amount - arr[i] >= 0)
            pick = helper(amount -arr[i], arr, i);

        int notPick = helper(amount, arr, i+1);

        return dp[i][amount] = pick +notPick;
    }
}
