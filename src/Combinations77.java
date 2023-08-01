class Solution {
    List<List<Integer>> ls;
    public List<List<Integer>> combine(int n, int k) {
        ls = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(list, k, 1, n);
        return ls;
    }

    public void helper(List<Integer> list, int k, int i, int n)
    {
        if(list.size() == k)
        {
            ls.add(new ArrayList<>(list));
            return ;
        }

        if(i > n)
            return ;
        
        list.add(i);
        helper(list, k, i+1, n);
        list.remove(list.size() - 1);
        helper(list, k, i+1, n);
    }
}
