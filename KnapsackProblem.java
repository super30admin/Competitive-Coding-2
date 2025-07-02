// Time Complexity: O(n * W) where n = number of items (wt.length) , W = knapsack capacity
// Space Complexity: O(n * W) for DP table of size (n+1) x (W+1)
// Did this code successfully run on Leetcode: Yes(Geeks for Geeks)
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - Bottom-up Dynamic Programming approach for the 0/1 Knapsack problem.
// - DP table `dp[i][j]` represents the maximum value for the first i items with capacity j.
// - First row (i=0) and first column (j=0) are set to 0, meaning no items or zero capacity yields 0 value.
// - If the current item's weight is greater than the current capacity `j`, we cannot pick it, so:
//        dp[i][j] = dp[i-1][j]
//  - Otherwise, choose the maximum of:
//        1. Not picking the item → dp[i-1][j]
//        2. Picking the item → dp[i-1][j - wt[i-1]] + val[i-1]
// - Return dp[n][W] which contains the maximum value achievable.
class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int m = wt.length;
        int[][] dp = new int[m+1][W+1];

        //Populate the 1st row and column
        for(int i=0; i<=m; i++){
            dp[i][0] = 0;
        }
        for(int j=1; j<=W; j++){
            dp[0][j] = 0;
        }

        //Populate the dp matrix
        for(int i=1; i<=m; i++){
            for(int j=1; j<=W; j++){
                if(j-wt[i-1] < 0){
                    dp[i][j] = dp[i-1][j];//Top
                }else{
                    // Max of not picking and picking the item
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }

        return dp[m][W];
    }
}
