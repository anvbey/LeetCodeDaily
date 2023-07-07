class Solution {
    public int maxConsecutiveAnswers(String key, int k) {
        int start=0;
        int  ans=0, max=0;
        int k1= k;
        for(int i =0;i<key.length();i++)
        {
            char x = key.charAt(i);
            if(x == 'F')
            {
                if(k == 0)
                {
                    while(key.charAt(start) == 'T')
                        start++;
                    start++;
                }
                else
                {
                    k--;
                }
            }
            ans = i - start +1;
            max = Math.max(max, ans);
        }
        start=0;
        ans=0;
        int max1=0;
        k = k1;
        for(int i =0;i<key.length();i++)
        {
            char x = key.charAt(i);
            if(x == 'T')
            {
                if(k == 0)
                {
                    
                    while(key.charAt(start) == 'F')
                    {
                        
                        start++;
                    }
                    start++;
                }
                else
                {
                    k--;
                }
            }

            ans = i - start+1;
            max1 = Math.max(max1, ans);
        }

        return Math.max(max, max1);
    }
}
