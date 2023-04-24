// 0/1 Knapsack

// Time Complexity : O(nW)
// Space Complexity : O(nW) to store the sub-problems
// Did this code successfully run on Leetcode : Yes (GFG)
// Any problem you faced while coding this : None

/*

Approach:
0/1 Knapsack problem states that we either choose or don't choose the item as
there is only one quantity of each item, and that we have to maximize the
"profit" that can be put into a bag of capacity W.
The optimized approach for this problem involves usage of a 2D array where the
columns are the weight values and the rows are the items. In order to compute
the final solution, we solve the smaller sub-problems all the way from 1 item
and 1 weight to all the items at the given weight.

*/

class Solution {

    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        if (wt == null || n == 0 || wt.length == 0) {
            return 0;
        }

        // first row and column are already zeroes
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    // sack won't hold this item
                    // so assume "don't choose" case for this item
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j], // don't choose case
                            val[i - 1] + dp[i - 1][j - wt[i - 1]] // choose case
                    );
                }
            }
        }

        return dp[n][W];
    }
}