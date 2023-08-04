class Solution {
    static int n;
    static int m;
    public int maxAreaOfIsland(int[][] grid) {
        
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j] == 1 )
                {
                    // vis[i][j] =true;
                    ans = Math.max(ans, bfs(grid, vis,i, j));
                }
            }
        }
        return ans;
    }
    static int coord[][] = {{-1,0},{1,0}, {0,-1},{0,1}};

    public int bfs(int arr[][], boolean vis[][], int x, int y)
    {
        // if(!isValid(x, y) || vis[x][y] || arr[x][y] == 0)
        // {
        //     return 0;
        // }
        // vis[x][y] = true;
        int count =1;
        arr[x][y] = 0;
        // Queue<Pair> q = new LinkedList<>();
        // q.add(new Pair(x, y));

        // while(!q.isEmpty())
        // {
            // Pair t = q.peek();
            // int a = t.first;
            // int b = t.second;
            // q.remove();
            for(int i=0;i<4;i++)
            {
                int nRow = coord[i][0] + x;
                int nCol = coord[i][1] + y;

                if(isValid(nRow, nCol) && arr[nRow][nCol] == 1)
                {
                    // q.add(new Pair(nRow, nCol));
                    // vis[nRow][nCol] = true;
                    // ans++;
                    count +=  bfs(arr, vis, nRow,nCol);
                }
            }
        

        return count;
    }

    public boolean isValid(int x, int y)
    {
        return (x >=0 && x < n && y>=0 && y<m);
    }
}

class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
