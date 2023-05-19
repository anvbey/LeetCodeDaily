class Solution {
    long dp[];
    public long mostPoints(int[][] questions) {
        
        dp = new long[questions.length+1];
        
        for(int i=0;i<questions.length+1;i++)
            dp[i] =-1;
        
        return fun(0, questions, dp);
        
        // long max=0;

        // for(int i=0;i<dp.length;i++)
        // {
        //     max = Math.max(max , dp[i]);
        // }

        // return max;
    }

    public long fun(int i, int arr[][], long dp[])
    {
        if(i >arr.length-1)
        {
            return 0;
        }

        if(dp[i] != -1)
        {
            return dp[i];
        }

        long taken = arr[i][0] + fun(i+arr[i][1]+1, arr, dp);
        long nottaken = fun(i+1, arr, dp);

        return dp[i] = Math.max(taken, nottaken);
    }
}
