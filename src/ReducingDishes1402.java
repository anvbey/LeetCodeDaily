class Solution {
    Integer dp[][];
    public int maxSatisfaction(int[] arr) {
        

        Arrays.sort(arr);
        int n= arr.length;
        this.dp= new Integer[n+1][n+1];
        return solve(0, n, arr, 1);
        
        
    }

    public int solve(int ind, int n, int arr[], int val){

        if(ind >= n)
            return 0;

        if(dp[ind][val] != null)
            return dp[ind][val];
        
        int pick = arr[ind] * val + solve(ind + 1, n , arr, val + 1);
        int notpick = 0 + solve(ind + 1, n , arr, val); 

        return dp[ind][val] = Math.max(pick, notpick);
    }
}
