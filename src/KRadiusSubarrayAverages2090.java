class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        if(k==0) return nums;
        if(k >= n) return ans;
        long sum=0;

        for(int i=0;i<k;i++){
            if(i+k+1 >= n) return ans;
           sum += (long)nums[i]+(long)nums[i+k+1];
        }
        sum+=nums[k];

        for(int i=k;i<n-k;i++){
            ans[i]= (int)(sum/((2*k)+1));
            sum -= (long)nums[i-k];
            if(n == i+k+1) return ans;
            sum+=(long) nums[i+k+1];
        }
        return ans;
    }
}
