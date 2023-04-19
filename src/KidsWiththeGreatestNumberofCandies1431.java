class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max= candies[0];
        for(int i=0;i<candies.length;i++)
        {
            max = Math.max(max, candies[i]);
        }
        List<Boolean> ls = new ArrayList<>();
        for(int i=0;i<candies.length;i++)
        {
            if(extraCandies + candies[i] >= max)
            {
                ls.add(true);
            }
            else
                ls.add(false);
        }

        return ls;
    }
}
