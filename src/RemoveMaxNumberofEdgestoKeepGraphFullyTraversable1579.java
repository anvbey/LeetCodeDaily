class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0]-a[0]);

        int alice[] = new int[n+1];
        int bob[] = new int[n+1];

        for(int i=0; i<n; i++) {
            alice[i] = i;
            bob[i] =i;
        }

        int cntAlice = 0;
        int cntBob= 0;
        int removedEdges = 0;

        for(int[] edge : edges) {

        int type = edge[0];
        int u = edge[1];
        int v = edge[2];

       

        if(type ==3) {
            boolean tempAlice = Union(u, v, alice);
            boolean tempBob = Union(u, v, bob);

            if(tempAlice == true && tempBob == true) {
                 cntAlice++;
                 cntBob++;
            }

            if(tempAlice == false && tempBob == false) {
                removedEdges++;
            }
        }else if(type == 2) {
            boolean tempBob = Union(u,v,bob);

            if(tempBob == true) {
                cntBob++;
            }else {
                removedEdges++;
            }

        }else {
            boolean tempAlice = Union(u,v,alice);
            if(tempAlice == true) {
                cntAlice++;
            }else {
                removedEdges++;
            }
        }
        }
        return cntAlice == n-1 && cntBob == n-1 ? removedEdges : -1;
    }
    public int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }
    public boolean Union(int x, int y, int[] parent) {
        int lx = find(x, parent);
        int ly = find(y, parent);

        if(lx != ly) {
            parent[lx] = ly;
            return true;
        }
        return false;
    }
}
