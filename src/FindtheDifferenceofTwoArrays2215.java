class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ls = new ArrayList<>();
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            map1.put(nums1[i],i);
        }
        for (Map.Entry<Integer,Integer> entry : map1.entrySet()) //using map.entrySet() for iteration
        {  
            //returns keys and values respectively  
            System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());   
        }   
        List<Integer> l1= new ArrayList<>();

        for(int i=0;i<nums2.length;i++)
        {
            if(!map1.containsKey(nums2[i]) && !l1.contains(nums2[i]))
            {
                System.out.println(nums2[i]);
                l1.add(nums2[i]);
            }
        }
        
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
            map2.put(nums2[i],i);
        }
        List<Integer> l2= new ArrayList<>();

        for(int i=0;i<nums1.length;i++)
        {
            if(!map2.containsKey(nums1[i]) && !l2.contains(nums1[i]))
            {
                l2.add(nums1[i]);
            }
        }

        ls.add(l2);
        ls.add(l1);
        return ls;
    }
}
