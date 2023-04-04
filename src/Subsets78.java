class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> temp;
    public List<List<Integer>> subsets(int[] arr) {
        res = new LinkedList<>();
        temp = new LinkedList<>();

        solve(0, arr);

        return res;
    }

    public void solve(int i, int arr[])
    {
        res.add(new LinkedList<>(temp));

        
        for(int start= i;start< arr.length;start++)
        {
            temp.add(arr[start]);
            solve(start+1, arr);

            temp.removeLast();
        }
    }
}
