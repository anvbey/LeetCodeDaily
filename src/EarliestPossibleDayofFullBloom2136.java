class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int arr[][] = new int[n][2];

        for(int i=0;i<n;i++)
        {
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }

        Arrays.sort(arr, (a,b) -> (b[1] - a[1]));
        
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i][0] + " "+ arr[i][1]);
        }
        int time = 0;
        int max = 0;

        for(int i=0;i<n;i++)
        {
            time += arr[i][0];

            max = Math.max(max , arr[i][1] + time);
        }

        return max;
    }
}
