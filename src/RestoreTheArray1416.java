class Solution {
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        //memoize
        Long[] dp = new Long[s.length()];
        return (int)memoize(0, s, k, dp);
      
    }

    public long memoize(int st, String s, int k, Long[] dp){
        if(st >= s.length()){
            return 1;
        }
        if(dp[st] != null) return dp[st];
        long count = 0;
        for(int i = st; i < s.length(); i++){
            long val = Long.parseLong(s.substring(st, i + 1));
            if(val > k || val == 0) break;
            count += memoize(i + 1, s, k, dp) % mod;
        }
        return dp[st] = count % mod;
    }
}
