class Solution {
    public int longestSubarray(int[] nums) {
        int left[] = new int[nums.length];
        left[0]= 0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1] == 1)
                left[i]+=left[i-1]+1;
            else
                left[i] = 0;
        }
        int right[] = new int[nums.length];
        left[nums.length-1]= 0;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i+1] == 1)
                right[i]+=right[i+1]+1;
            else
                right[i] = 0;
        }

        int max =0;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(max, left[i] + right[i]);
        }

        return max;
    }
}
