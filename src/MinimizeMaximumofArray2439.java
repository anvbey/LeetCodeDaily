class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        long ans=0;
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum +=nums[i];

            long avg = (long)Math.ceil((double)(sum) / (i+1));

            ans = Math.max(ans, avg); 
        }
        return (int)ans;
    }
}
