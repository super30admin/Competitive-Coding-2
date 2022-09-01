// Knapsack Problem

// Time Complexity : O(n*capacity)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Could not find link of Leetcode problem
// Any problem you faced while coding this : NO
class Problem1{

    int knapSack(int W, int wt[], int val[]) {

        //null check
        if (W == null || wt == null || val == null || wt.length == 0 || val.length == 0) return 0;

        int n = wt.length;
        int w = val.length;

        int[][] dp = new int[w + 1][n + 1];

        //fill the dummy row
        dp[0][0] = 0;

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 2; i < wt.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (j >= W) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], wt[i + 1] + dp[i - 1][j - wt[i - 1]]);
                }

            }

        }

        return dp[w][n];
    }
}