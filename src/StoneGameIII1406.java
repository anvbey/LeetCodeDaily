class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int ps = 0, dp[] = new int[stoneValue.length+3];
        for (int i=stoneValue.length-1; i>=0; ps += stoneValue[i--])
            dp[i] = stoneValue[i] + ps - Math.min(dp[i+1], Math.min(dp[i+2], dp[i+3]));
        return dp[0] > ps-dp[0] ? "Alice" : dp[0] == ps-dp[0] ? "Tie" : "Bob";
    }
}
