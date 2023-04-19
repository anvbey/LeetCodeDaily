class Solution {
    public int numWays(String[] words, String target) {

        int n=target.length();
        long mod = (long)1e9 + 7, res[]=new long[n+1];
        res[0]=1;
        for(int i=0; i<words[0].length(); i++) {
            int[] count = new int[26];
            //count of each char at index i for all words
            for(String w:words)
                count[w.charAt(i)-'a']++;
            //dp first j+1 chars = dp first j chars * new char count
            //after addition it can spill so we do mod operation 2 times.
            for(int j=n-1; j>=0; j--)
                res[j+1] += res[j]*count[target.charAt(j)-'a']%mod;
        }
        return (int)(res[n]%mod);
    }
}
