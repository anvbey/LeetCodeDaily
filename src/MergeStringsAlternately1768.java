class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i,j;
        String res="";
        for(i=0,j=0;i<word1.length() && j<word2.length();i++,j++)
        {
            char x =word1.charAt(i);
            char y =word2.charAt(j);
            res+= x;
            res+= y;
        }

        res += word1.substring(i);
        res+= word2.substring(j);

        return res;
    }
}
