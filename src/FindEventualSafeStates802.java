class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        if (graph == null || graph.length == 0)
            return result;

        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i, color))
                result.add(i);
        }

        return result;
    }

    private boolean isSafe(int[][] graph, int node, int[] color) {
        if (color[node] != 0)
            return color[node] == 1;

        color[node] = 2; // Mark current node as visited

        for (int neighbor : graph[node]) {
            if (!isSafe(graph, neighbor, color))
                return false;
        }

        color[node] = 1; // Mark current node as safe
        return true;
    }

}
