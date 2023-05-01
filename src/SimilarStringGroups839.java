class Solution {
    public int numSimilarGroups(String[] strs) {
       
        int n=strs.length;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>()); 
        } 

        for(int i=0;i<strs.length;i++)
        {
            for(int j=i+1;j<strs.length;j++)
            {
                if(similarStrings(strs[i],strs[j]))
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int res = 0;
        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++) 
            if(visited[i] == 0) {
                res++; 
                dfs(i, adjList, visited);
            }
        return res;
        
    
    }
     public boolean similarStrings(String s1, String s2) {
        int ch = 0, m = s1.length();
        for(int i = 0; i < m; i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                ch++;
            } 
        }
        if(ch>2)return false; 
        return true; 
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        visited[node] = 1;
        for(int adj : adjList.get(node)){
            if(visited[adj] == 0) dfs(adj, adjList, visited);
        }
}
    }
