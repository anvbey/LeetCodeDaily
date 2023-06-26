class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        long ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        // use two hashmaps one for front and the other for the back
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int start= candidates;
        for(int i=0;i<candidates;i++)
        {
            map1.put(costs[i], map1.getOrDefault(costs[i],0)+1);
        }
        int end = costs.length - candidates;
        for(int i=costs.length-1;(i>=costs.length -candidates) && (i > candidates-1);i--)
        {
            map2.put(costs[i], map2.getOrDefault(costs[i],0)+1);
        }

        // Iterate HashMap and put it into the priority queue
        for (Map.Entry<Integer,Integer> entry : map1.entrySet()) 
            for(int i=0;i<entry.getValue();i++)
            {
                
                pq.add(entry.getKey());
            }
        
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) 
            for(int i=0;i<entry.getValue();i++)
            {
                System.out.println(entry.getKey() + " " + entry.getValue());
                pq.add(entry.getKey());
            }

        // Iterate the priorityqueue and check which has the lowest number add the number into the priority queue
        while(k > 0)
        {
            int element = pq.remove();
            if(map1.containsKey(element))
            {
                if(map1.get(element) > 1)
                {
                    map1.put(element, map1.get(element)-1);
                }
                else
                {
                    map1.remove(element);
                }
                if(start < end)
                {
                    
                    
                    map1.put(costs[start], map1.getOrDefault(costs[start], 0) + 1);
                    pq.add(costs[start]);
                    start++;
                }
            }
            else{
                if(map2.get(element) > 1)
                {
                    map2.put(element, map2.get(element)-1);
                }
                else
                {
                    map2.remove(element);
                }
                if(end > start)
                {
                    end--;
                    map2.put(costs[end], map2.getOrDefault(costs[end], 0) + 1);
                    pq.add(costs[end]);
                }
            }
            k--;
            ans += element;
        }


        return ans;
    }
}
