// Time complexity: O(capacity * n)
// Space complexity: O(capacity * n)
//Approach: Create a decision tree. And start with bottom up dp;
// The dp matrix will have two inputs; index (values) and current capacity
// From the left: current capacity will be 0 uptill the max capacity

class Problem2 {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n][W + 1];
        // filling the last row; if only one item is available
        for (int i = 0; i < dp[0].length; i++) {
            // if available weight is more than last item's weight
            if (wt[n - 1] <= i) {
                dp[n - 1][i] = val[n - 1];
            } else {
                // item's weight is larger than the knapsack capacity at this point
                dp[n - 1][i] = 0;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                // current knapsack capacity is less than item's weight
                // can't add the current item at the given capacity
                if (j < wt[i] || j - wt[i] < 0) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    // max of choose or dont choose
                    dp[i][j] = Math.max(dp[i + 1][j], val[i] + dp[i + 1][j - wt[i]]);
                }
            }
        }

        return dp[0][dp[0].length - 1];
    }
}