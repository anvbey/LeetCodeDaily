class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long start= 0;
        long end = 0;
        for(int i = 0; i < batteries.length; i++){
            end += batteries[i];
        }
        Arrays.sort(batteries);
        long ans=0;
        while(start <= end)
        {
            long mid = start + (end- start)/2;

            if(isPossible(mid, n, batteries))
            {
                ans = mid;
                start = mid +1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }

    public boolean isPossible(long mid, int n, int[] arr)
    {
        long s =0;
        for(int i: arr)
        {
            if(i< mid)
                s+=i;
            else
                s+= mid;
        }

        return (s>= mid*n);
    }
}
