class Solution {
    public int minReorder(int n, int[][] connections) {
        // We'll make the graph in arrayList
        // then check whether the adjacent nodes to Zero are directed to Zero
        // and mark them visited
        // basically bfs

        // ArrayList
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
            ls.add(new ArrayList<>());
        
        for(int i=0;i<connections.length;i++)
        {
            ls.get(connections[i][0]).add(connections[i][1]);
            ls.get(connections[i][1]).add(-connections[i][0]);
        }
        int ans=0;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] =true;
        
        while(!q.isEmpty()){
            int curr= q.poll();

            for(int id:ls.get(Math.abs(curr)))
            {
                if(!vis[Math.abs(id)])
                {
                    q.add(id);
                    vis[Math.abs(id)] = true;

                    if(id > 0)
                        ans++;
                }
            }
        }

        return ans;
    }
}
