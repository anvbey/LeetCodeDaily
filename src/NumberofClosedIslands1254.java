class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        boolean[] foundEdge = new boolean[]{false};
        boolean[][] visited = new boolean[m][n];
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    foundEdge[0] = false;
                    bfs(i, j, grid, directions, visited, foundEdge);
                    if(!foundEdge[0]){
                       result++; 
                    }
                    
                }
            }
        }
        return result;
    }
    private void bfs(int x, int y, int[][] grid, int[][] directions, boolean[][] visited, boolean[] foundEdge){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            for(int[] dir : directions){
                int nextX = currentX + dir[0];
                int nextY = currentY + dir[1];
                if(valid(nextX, nextY, grid, visited)){
                    visited[nextX][nextY] = true;
                    if(nextX == 0 || nextX == grid.length - 1 || nextY == 0 || nextY == grid[0].length - 1 || x == 0 || y == 0){
                        foundEdge[0] = true;
                    }
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
    private boolean valid(int x, int y, int[][] grid, boolean[][] visited){
        return x >= 0 && x < grid.length  && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == 0;
    }
}
