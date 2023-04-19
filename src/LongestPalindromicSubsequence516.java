class Solution {
    public int longestPalindromeSubseq(String s) {
      int lenOfS = s.length();
        int[][] dp = new int[lenOfS][lenOfS];
        return findLongestPalindrome(0, lenOfS-1, s, dp);
    }

    public int findLongestPalindrome(int start, int end, String s, int[][] dp){
        if(start > end){
            return 0;
        }
        if(dp[start][end] != 0){
            return dp[start][end];
        }
        if(s.charAt(start) == s.charAt(end)){
            int twoOrOneChars = (start == end)? 1:2;
            dp[start][end] = findLongestPalindrome(start+1, end-1, s, dp) + twoOrOneChars;
        }else{
            dp[start][end] = Math.max(findLongestPalindrome(start+1, end, s, dp), findLongestPalindrome(start, end-1, s, dp));
        }

        return dp[start][end];
    }
}
