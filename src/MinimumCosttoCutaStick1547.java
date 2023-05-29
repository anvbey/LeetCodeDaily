import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length + 2]; // 0 1 2 ... n-1 n -> n +1
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        //arraycopy(source_arr, sourcePos, dest_arr, destPos, len)
        System.arraycopy(cuts, 0, newCuts, 1, cuts.length); // 0, 1, 3, 4, 5, 7
        Arrays.sort(newCuts);

        int[][] dp = new int[newCuts.length][newCuts.length];

        for (int len = 2; len < newCuts.length; len++) {
            for (int left = 0; left + len < newCuts.length; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                // e.g. [0][5], k will iterate [0][1] + [1][5], [0,2] + [2,5], [0,3] + [3,5], [0,4] + [4,5] to find the lowest, this is due to k being the indicator of where the cut was performed, thus dp[] will produce the cost of [left,k] & [k, right]
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k][right] + newCuts[right] - newCuts[left]);
                }
            }
        }

        return dp[0][newCuts.length - 1];
    }
}




// import java.util.Arrays;

// class Solution {
//     public int minCost(int n, int[] cuts) {
//         // Sort the cuts in ascending order
//         Arrays.sort(cuts);

//         int[][] dp = new int[n + 2][n + 2];
//         return dfs(0, n, cuts, dp);
//     }

//     public int dfs(int left, int right, int[] cuts, int[][] dp) {
//         if (right - left == 1) {
//             return 0;
//         }

//         if (dp[left][right] != 0) {
//             return dp[left][right];
//         }

//         int res = Integer.MAX_VALUE;
//         for (int i = 0; i < cuts.length; i++) {
//             if (left < cuts[i] && cuts[i] < right) {
//                 res = Math.min(res, (right - left) + dfs(left, cuts[i], cuts, dp) + dfs(cuts[i], right, cuts, dp));
//             }
//         }

//         if (res == Integer.MAX_VALUE) {
//             res = 0;
//         }

//         dp[left][right] = res;
//         return res;
//     }
// }
