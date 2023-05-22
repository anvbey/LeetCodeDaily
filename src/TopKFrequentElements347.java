class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> temp=new HashMap<>();
        for(int i=0; i<nums.length; i++) temp.put(nums[i], temp.getOrDefault(nums[i], 0) +1);
        int ans[]=new int[k];
        int arr[][]=new int[temp.size()][2];
        int p=0;
        for(Integer i:temp.keySet()){
            arr[p][0]=i;
            arr[p++][1]=temp.get(i);
        }
        Arrays.sort(arr, (a, b)-> b[1]-a[1]);
        for(int i=0; i<k; i++) ans[i]=arr[i][0];
        return ans;
    }

}
