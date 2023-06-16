class Solution {

    private static final int mod = 1000000007;
    private static final long[][] table = calculateCombinationTable(1000);

    public int numOfWays(int[] nums) {        
        long ans = helper(Arrays.stream(nums).boxed().toList());

        return (int)ans - 1;
    }

    private long helper(List<Integer> list) {
		int len = list.size();
        if(len < 3) return 1; // only one valid array when having less than 3 nodes

        int rootVal = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 1; i < len; i++) {
            if(list.get(i) <= rootVal) left.add(list.get(i));
            else right.add(list.get(i));
        }

		long leftCount = helper(left) % mod;
		long rightCount = helper(right) % mod;
        long comb = table[len - 1][left.size()]; // # of combinations for every pair of left array and right array
        long ans = (((leftCount * rightCount) % mod) * comb) % mod;
        return ans;
    }

    private static long[][] calculateCombinationTable(int m) {
        long[][] t = new long[m][m];
        for (int i = 0; i < m; ++i) {
            t[i][0] = t[i][i] = 1;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                t[i][j] = (t[i - 1][j - 1] + t[i - 1][j]) % mod;
            }
        }
        return t;
    }
}
