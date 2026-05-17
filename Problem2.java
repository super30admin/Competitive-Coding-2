// Time Complexity : O(n * W) where n is number of items and W is the capacity of the knapsack
// Space Complexity : O(n * W)
// Did this code successfully run on GeeksForGeeks : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use dynamic programming where dp[i][w] stores the maximum value we can get using the first i items with capacity w.
// For every item, we have two choices: skip it, or take it if its weight is less than or equal to the current capacity.
// The answer is stored in dp[n][W], which represents the best value possible using all items and full capacity.

class Solution {

    static int knapSack(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= W; w++) {

                // skip current item
                dp[i][w] = dp[i - 1][w];

                // take current item if it fits
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i][w],
                        val[i - 1] + dp[i - 1][w - wt[i - 1]]
                    );
                }
            }
        }

        return dp[n][W];
    }
}