class Solution {
    List<List<Integer>> ls;
    public List<List<Integer>> permute(int[] nums) {
        ls = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        boolean vis[]= new boolean[nums.length];
        helper(list, nums, nums.length, vis);

        return ls;
    }

    public void helper(List<Integer> list, int arr[], int n, boolean vis[])
    {
        if(list.size() == n)
        {
            ls.add(new ArrayList<>(list));
            return ;
        }

        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                vis[i] = true;
                list.add(arr[i]);
                helper(list, arr, n, vis);
                list.remove(list.size()-1);
                vis[i] = false;
            }
        }
    }
}
