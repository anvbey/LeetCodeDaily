class Solution {

   int[] dx = {1, -1, 0, 0};
   int[] dy = {0, 0, 1, -1};


    public boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }

    public void DFS(int grid[][], int i, int j){
        if(grid[i][j]==0 || grid[i][j]==2)
        return;

        grid[i][j]=2;

        for(int k=0; k<4; k++){
            int nx=i+dx[k];
            int ny=j+dy[k];

            if(isValid(nx,ny,grid.length)){
                DFS(grid,nx,ny);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        // first i will convert one of the islands to all 2''s using dfs
        int col=0;
        int row=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1)
                {
                    row=i;
                    col=j;
                }
            }
        }
        DFS(grid,row,col);
        // now i want shortest distance between any occurence of 2 and 1
        // for this we will use multisource bfs 


        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        // Find all occurrences of 2 and add them to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int minDistance = 0;

        // Perform multisource BFS to calculate minimum distances
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                if (grid[x][y] == 1) {
                    return minDistance-1;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (isValid(nx, ny, n) && !visited[nx][ny] && grid[nx][ny] != 2) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            minDistance++;
        }

        return -1; // No valid path found
    }
}
