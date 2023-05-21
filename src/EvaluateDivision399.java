class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String , Map<String, Double>> graph = makeGraph(equations, values);
        double ans[] = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            ans[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }

        return ans;
    }
    private Map<String , Map<String, Double>> makeGraph(List<List<String>> equations, double[] values){
        Map<String , Map<String, Double>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String s = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            map.putIfAbsent(s, new HashMap<>());
            map.get(s).put(v, values[i]);

            map.putIfAbsent(v, new HashMap<>());
            map.get(v).put(s, 1/values[i]);
        }
        return map;
    }

    private double dfs(Map<String , Map<String, Double>> graph, String src, String dst, Set<String> visited){
        if(!graph.containsKey(src)){
            return -1.0;
        }
        if(graph.get(src).containsKey(dst)){
            return graph.get(src).get(dst);
        }

        visited.add(src);

        for(Map.Entry<String, Double> e:graph.get(src).entrySet()){
            if(!visited.contains(e.getKey())){
                double weight = dfs(graph, e.getKey(), dst, visited);

                if(weight != -1){
                    return e.getValue() * weight;
                }
            }
        }
        return -1.0;
    }

}
