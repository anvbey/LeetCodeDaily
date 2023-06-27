class Solution {
    static Integer dp[][];
    public int lengthOfLIS(int[] nums) {
        
        dp = new Integer[nums.length][nums.length];
        return helper(nums, 0, -1, 0);
    }

    public static int helper(int arr[], int i, int last, int count)
    {
        //base condition
        if(i == arr.length)
            return 0;
        
        if(dp[i][last + 1] != null)
            return dp[i][last+1];
        int take =0, notTake=0;

        if( last == -1 || arr[i] > arr[last] )
        {
            take = 1 + helper(arr, i+1, i, count+1);
        }

        notTake = helper(arr, i+1, last, count);

        return dp[i][last+1] =  Math.max(take, notTake);
    }
}
