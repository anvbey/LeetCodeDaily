class Solution {
    ArrayList<Integer> color = new ArrayList<>();
    boolean ans = true;

    public boolean isBipartite(int[][] graph) {
          int[] nodeColor = new int[graph.length];
          boolean[] vis = new boolean[graph.length];
          color.add(1);
         
    boolean tempAns = true;
    for(int i = 0 ;i < vis.length ;i++){
            nodeColor[i] = 1;
            tempAns = tempAns && backT(i,graph,vis,nodeColor);

    }
        return tempAns;
    }

    boolean backT(int v , int[][] graph , boolean[] vis,int[] nodeColor) {
        vis[v] = true;
       
        for(int i : graph[v]) {
            if(!vis[i]) {
                       
                        if(nodeColor[i] == 0) {
            if(!isSafe(graph,i,nodeColor)) return false;
          ans =   backT(i,graph,vis,nodeColor) && ans;
        }
            }

    }
            return ans;
    }

     boolean isSafe(int[][] graph ,int curNode ,int[] colorAr) {
      
        for(Integer i : color){
              boolean flag = false;
            for(int z : graph[curNode]) {
                
                    if(i == colorAr[z]) {
                        flag = true;
                        break;
                    }
                
            }
            if(flag == true)  continue;
            else {
                colorAr[curNode] = i;
                return true;
            }
        }

     
        if(color.size() == 2){
        //   flagSize = true;
return false;
        } 
        color.add(2);
        colorAr[curNode] = 2;
        return true;
    }
}
