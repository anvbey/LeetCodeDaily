class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if((i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1) && grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                } 
                    
            }
        }
        int[] temprow = {-1, 0, +1, 0};
        int[] tempcol = {0, +1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++){
                int rown = x + temprow[i];
                int coln = y + tempcol[i];
                if(rown >= 0 && rown < grid.length && coln >= 0 && coln < grid[0].length && visited[rown][coln] != 1 && grid[rown][coln] == 1){
                    visited[rown][coln] = 1;
                    q.add(new Pair(rown, coln));
                }
            }
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] != 1) count++;
            }
        }
        return count;
    }
}

class Pair {
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
