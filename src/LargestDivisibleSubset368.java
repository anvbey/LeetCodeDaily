class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int dp [] = new int[nums.length];
        Arrays.sort(nums);

        int max=0;

        for(int i=0;i<nums.length;i++)
        {
            for(int j= i+1;j<nums.length;j++)
            {
                if(nums[j] % nums[i] == 0)
                {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    max = Math.max(max, dp[j]);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i= nums.length-1; i>=0; i--)
        {
            if(dp[i] == max && (ans.size() > 0? ans.get(ans.size() -1) % nums[i] == 0 : true)){
                ans.add(nums[i]);
                max--;
            }
        }

        return ans;
    }
}
