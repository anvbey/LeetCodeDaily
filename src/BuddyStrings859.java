class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        int flag= 0;
        for(int i=0;i<s.length();i++)
        {
            arr1[(int)(s.charAt(i)-'a')]++;
            arr2[(int)(goal.charAt(i)-'a')]++;
            if(s.charAt(i) != goal.charAt(i))
                flag++;
        }
        boolean flag1 = false;

        for(int i=0;i<26;i++)
        {
            if(arr1[i] != arr2[i])
                return false;
            
            if(arr1[i]> 1)
                flag1 = true;
        }

        if(s.equals(goal) && flag1)
            return true;
        
        if(!s.equals(goal) && flag == 2)
            return true;
        
        return false;
    }
}
