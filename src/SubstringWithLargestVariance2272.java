class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        int [][]dp1 = new int[26][26];
        int [][]dp2 = new int[26][26];
        for(int i=0; i<26; i++){
            Arrays.fill(dp2[i], -s.length());
        }
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i)-'a';
            for(int j=0; j<26; j++){
                if(j==c){
                    continue;
                }
                ++dp1[c][j];
                ++dp2[c][j];
                dp2[j][c] = --dp1[j][c];
                dp1[j][c] = Math.max(dp1[j][c], 0);
                ans = Math.max(ans, Math.max(dp2[c][j], dp2[j][c]));
            }
        }
        return ans;
    }
}
