// Time Complexity : O(n*W)
// Space Complexity : O(n*W)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

class Knapsack {
    static int knapSack(int[] wt, int[] val, int W, int n) {

        int[][] dp = new int[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; i++) {
                dp[i][j] = -1;
            }
        }
        // Base case
        if (n == 0 || W == 0) {
            return 0;
        }
        // Memoized
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        // Recursive calls
        if (wt[n-1] <= W) {
            dp[n][W] = Math.max(val[n-1] + knapSack(wt, val, W-wt[n-1], n-1), knapSack(wt, val, W, n-1));
        }
        else {
            dp[n][W] = knapSack(wt, val, W, n-1);
        }
        return dp[n][W];
    }
}