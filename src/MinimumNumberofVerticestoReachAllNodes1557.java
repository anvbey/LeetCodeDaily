class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list= new ArrayList<>();

        boolean vis[] = new boolean[n];

        for(int i=0;i<edges.size();i++)
        {
            vis[edges.get(i).get(1)] = true;
        }

        while(n-- > 0)
        {
            if(vis[n] == false)
                list.add(n);
        }

        return list;
    }
}
