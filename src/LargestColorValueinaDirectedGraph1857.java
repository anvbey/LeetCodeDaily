class Solution {

    public static final int[] IN_FLIGHT = {-1};
    public static final int NUM_COLORS = 26;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] maxCount = new int[n][];

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int[] edge: edges) {
            if (adj[edge[0]] == null) adj[edge[0]] = new ArrayList<>();
            adj[edge[0]].add(edge[1]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (dfs(colors, adj, maxCount, i) == IN_FLIGHT) return -1;
        }
        return Arrays.stream(maxCount).flatMapToInt(Arrays::stream).max().getAsInt();
    }

    private int[] dfs(String colors, ArrayList<Integer>[] adj, int[][] maxCount, int curr) {
        if (maxCount[curr] == null) {
            maxCount[curr] = IN_FLIGHT;
            int[] currCc = new int[NUM_COLORS];
            if (adj[curr] != null) {
                for (int nxt: adj[curr]) {
                    int[] nextCc = dfs(colors, adj, maxCount, nxt);
                    if (nextCc == IN_FLIGHT) return IN_FLIGHT;
                    for (int i = 0; i < NUM_COLORS; i++) {
                        currCc[i] = Math.max(currCc[i], nextCc[i]);
                    }
                }
            }
            currCc[colors.charAt(curr) - 'a']++;
            maxCount[curr] = currCc;
        }
        return maxCount[curr];
    }
}
