class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int last = intervals[0][1];
        int count=0;
        // System.out.println(intervals[0][0] +" " +intervals[0][1]);
        for(int i=1;i<intervals.length;i++)
        {
            // System.out.println(intervals[i][0] +" " +intervals[i][1]);
            if(intervals[i][0] < last)
            {
                // System.out.println(intervals[i][0] +" " +intervals[i][1] +" last= " + last );
                count++;
            }
            else
            {
                last = intervals[i][1];
            }
        }

        return count;
    }
}
