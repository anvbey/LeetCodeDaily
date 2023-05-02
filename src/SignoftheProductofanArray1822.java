class Solution {
    public int arraySign(int[] nums) {
        int neg=0;
        int zero=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
                neg++;
            else if(nums[i] == 0)
                zero++;
        }
        
        return zero>0?0:neg%2==0?1:-1;
    }
}
