class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int l = 1, r = 10000000;
        int flag= Integer.MAX_VALUE;

        while(l <= r)
        {
            int mid = (r+l)/2;
            double ans = findtime(dist, mid, hour);
            if(ans<= hour)
            {
                flag = Math.min(flag, mid);
                r= mid-1;
            }
            else
                l= mid + 1;
        }

        return flag == Integer.MAX_VALUE?-1:flag;
    }

    public static double findtime(int arr[],int mid,double hours)
    {
        double time=0;
        for (int i=0;i<arr.length-1;i++)
        {
            double c=Math.ceil((double) arr[i]/mid);
            time=time+c;
        }
        time=time+(double) arr[arr.length-1]/mid;
        return time;
    }
}
