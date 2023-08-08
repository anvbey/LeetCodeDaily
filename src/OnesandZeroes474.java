class Solution {
    Integer dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length][m+1][n+1];
        
        return helper(strs, m, n, 0, 0);
    }

    public int helper(String strs[], int m, int n, int i, int count)
    {
        if(strs.length == i)
            return 0;
        
        if(dp[i][m][n] != null)
            return dp[i][m][n];

        int M = m, N=n;
        String w = strs[i];
        for(int ind = 0;ind < strs[i].length();ind++)
        {
            char x = w.charAt(ind);
            if(x == '0')
                M--;
            else
                N--;
        }
        
        if(M < 0 || N < 0)
            return dp[i][m][n] = helper(strs, m, n, i+1, count);
        return dp[i][m][n] = Math.max(1 + helper(strs, M, N,i+1, count+1) , helper(strs,m,n,i+1,count));
    }
}
