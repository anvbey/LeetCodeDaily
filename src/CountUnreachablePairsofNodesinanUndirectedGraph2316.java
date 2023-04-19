class Solution {
    List<List<Integer>> ls;
    public long countPairs(int n, int[][] edges) {
        ls = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            ls.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            ls.get(edges[i][0]).add(edges[i][1]);
            ls.get(edges[i][1]).add(edges[i][0]);
        }

        long sum = (Long.valueOf(n)*(n-1))/2;
        boolean vis[] = new boolean[n];

        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                int count  = dfs(i, vis,new int[1]);
                sum -= (Long.valueOf(count) * (count-1))/2;
            }
        }

        return sum;
    }

    public int dfs(int i, boolean vis[], int arr[]){
        if(vis[i])
            return arr[0];
        
        vis[i] = true;
        arr[0]++;
        for(int curr: ls.get(i))
            dfs(curr, vis,arr);

        return arr[0];
    }
}
