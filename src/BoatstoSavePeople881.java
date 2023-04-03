class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans=0;
        Arrays.sort(people);
        int l=0, r= people.length-1;

        while(l<=r)
        {
            if(people[l]+ people[r]<= limit)
            {
                ans++;
                l++;
                r--;
            }
            else
            {
                r--;
                ans++;
            }
        }
        return ans;
    }
}
