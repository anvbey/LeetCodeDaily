class Solution {
    public int maxVowels(String s, int k) {
        
        int left= 0, right=0;
        int count=0;
        int max=0;
        while(right < s.length())
        {
            
            if((right-left) < k)
            {
                char x = s.charAt(right);
                if(x == 'a'||x == 'e'||x == 'i'||x == 'o'||x == 'u')
                    count++;
                right++;
            }
            else
            {
                char x = s.charAt(left);
                if(x == 'a'||x == 'e'||x == 'i'||x == 'o'||x == 'u')
                    count=count>0?count-1:0;
                left++;
                x = s.charAt(right);
                if(x == 'a'||x == 'e'||x == 'i'||x == 'o'||x == 'u')
                    count++;
                right++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
