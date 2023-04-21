class Solution {
    int mod = 1000000007;
    Integer dp[][][];
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        dp = new Integer[group.length][n+1][minProfit + 1];
        return (int)(helper(n, minProfit, group, profit, 0 ,0 ));
    }

    public int helper(int n, int min, int grp[], int profit[], int i, int count)
    {
        if(i >= grp.length && min <= 0 && count <= n)
        {
            return 1;
        }
        if(i == grp.length || count > n)
        {   
            return 0;
        }
        
        if(min < 0)
            min=0;
        
        if(dp[i][count][min] != null)
        {
            
            return dp[i][count][min];
        }
        int pick = helper(n, min - profit[i],grp, profit, i+1,count + grp[i]);
        
        int notPick = helper(n, min,grp, profit, i+1,count);

        return dp[i][count][min]= (pick + notPick) % mod;
    }
}
