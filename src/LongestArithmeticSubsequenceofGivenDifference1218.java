class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        int max= 1;
        for(int i = arr.length-1;i>=0;i--)
        {
            if(hs.contains(arr[i]))
            {
                int val = hm.get(arr[i] + difference) + 1;
                hm.put(arr[i], val);
                hs.add(arr[i] - difference);
                if(val > max)
                    max = val;
            }
            else
            {
                hs.add(arr[i] - difference);
                hm.put(arr[i], 1);
            }
        }

        return max;
    }
}
