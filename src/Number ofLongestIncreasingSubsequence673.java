class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n= arr.length;
        int dp[] = new int[n];
        int count[]= new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count, 1);
        int max = 1;
        for(int i=0;i<n;i++)
        {
            for(int j =0;j<i;j++)
            {
                
                if(arr[i] > arr[j] && 1 + dp[j] > dp[i])
                {
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                }
                else if(arr[i] > arr[j] && dp[i]  == dp[j]+ 1)
                {
                    count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);
        }

        
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i] == max)
            {
                c+= count[i];
            }
        }

        return c;
    }
}
