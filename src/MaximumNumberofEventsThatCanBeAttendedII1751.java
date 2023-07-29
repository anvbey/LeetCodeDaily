class Solution {
    Integer dp[][];
    public int maxValue(int[][] e, int k) {
        dp = new Integer[e.length+1][k+1];
        Arrays.sort(e, (a,b) -> a[0] != b[0]? a[0]- b[0]:a[1]-b[1]);
        return helper(e, k, 0, -1, 0);
    }

    public int helper(int arr[][], int k, int i, int last, int cost)
    {
        if(k == 0 || i == arr.length)
        {
            return 0;
        }
        
        if(last != -1 && dp[last][k] != null)
            return dp[last][k];
        // System.out.println(  i +" " + last +" " +k + " " + cost);

        int take= 0;
        int notTake =0;

        if(last == -1 || arr[last][1] < arr[i][0])
        {
            // System.out.println("Take");
            take = arr[i][2]+ helper(arr, k-1, i+1, i, cost + arr[i][2]);
        }
        // System.out.println("Not Take");
        notTake = helper(arr, k, i+1, last, cost);


        if(last != -1 )
            dp[last][k]=  Math.max(take, notTake);
        return Math.max(take, notTake);
    }
}
