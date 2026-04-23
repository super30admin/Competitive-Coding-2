// Time Complexity : O(n*W) where n is the number of items and W is the capacity of the knapsack
// Space Complexity : O(n*W) where n is the number of items and W is the capacity of the knapsack
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : A bit of confusion in buildin the dp table, but got it after some time.


// Your code here along with comments explaining your approach
//  Greedy or selective approach will not work here, 
// We need to go exhaustive and check for all the combinations of items to get the maximum value.
// We can use a 2D dp table to store the items and the capacity of the knapsack, and fill the table in a bottom up manner.
// We fill with the value of the item if we pick it, and the value of the previous item if we don't pick it, 
// Add the value of the item to the value of the remaining capacity if we pick it, and take the maximum of both.
class Knapsack {

    static int knapsack(int W, int[] val, int[] wt) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                // If there is no item or the knapsack's capacity is 0
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    int pick = 0;

                    // Pick ith item if it does not exceed the capacity of knapsack
                    if (wt[i - 1] <= j)
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];

                    // Don't pick the ith item
                    int notPick = dp[i - 1][j];

                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][W];
    }
}

