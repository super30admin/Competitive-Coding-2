// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
0/1 knapsack problem. Use DP.
*/
class Solution
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        //base case
        if (wt.length * val.length == 0) return 0;
        // your code here

        int[][] dp = new int[wt.length + 1][W + 1];
        // rows --> 0,4,5,1, cols--> 0,1,2,3,4

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}