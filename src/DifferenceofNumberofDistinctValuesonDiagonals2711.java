class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int ans[][] = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                //top-most
                HashSet<Integer> set = new HashSet<>();

                int ind1 = i-1;
                int ind2 = j-1;
                while((ind1 >= 0 && ind1 < grid.length) && (ind2 >= 0)){
                    set.add(grid[ind1][ind2]);
                    ind1--;
                    ind2--;
                }

                //bottom-most
                HashSet<Integer> set1 = new HashSet<>();
                ind1=i+1;
                ind2=j+1;

                while(ind1< grid.length&&ind2<grid[0].length){
                    set1.add(grid[ind1][ind2]);
                    ind1++;
                    ind2++;
                }

                ans[i][j] = Math.abs(set1.size() - set.size());
            }
        }

        return ans;
    }
}
