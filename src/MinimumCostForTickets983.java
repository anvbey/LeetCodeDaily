class Solution {

    int oneDayPassCost;
    int sevenDayPassCost; 
    int thirtyDayPassCost;
    int lastDay;
    List<Integer> daysList = new ArrayList<>();

    public int mincostTickets(int[] days, int[] costs) {
        
        int n = days.length;

        this.oneDayPassCost = costs[0];
        this.sevenDayPassCost = costs[1];
        this.thirtyDayPassCost = costs[2];

        for(int i=0;i<n;i++)
            daysList.add(days[i]);

        this.lastDay = days[n-1];

        int[] memo = new int[lastDay+1];
        
        Arrays.fill(memo,-1);


        return recursion(1,memo);
        
    }

    int recursion(int day,int[] memo){

        if(day > lastDay)
            return 0;
        

        if(memo[day] != -1)
            return memo[day];

        
        int mincostTickets;

        if(!daysList.contains(day))
            mincostTickets = recursion(day+1,memo);
        else{
            int x = oneDayPassCost + recursion(day+1,memo);
            
            int y = sevenDayPassCost + recursion(day+7,memo);
            
            int z = thirtyDayPassCost + recursion(day+30,memo);

            mincostTickets = Math.min(Math.min(x,y),z);
        }

        memo[day] = mincostTickets;
        
        return mincostTickets;
        
    }
}
