class Solution {
    public int singleNumber(int[] nums) {
        
        int p=0, q=0;
        for(int i=0;i<nums.length;i++)
        {
            p = (nums[i] ^ p) & ~q;
            q = (nums[i] ^ q) & ~p;
        }

        return p;
    }
}
