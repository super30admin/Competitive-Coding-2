// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class KnapsackSolution
{
    public static int knapsack2(int[] weights, int[] vals, int capacity) {
        if(vals == null || vals.length== 0 || weights == null || weights.length == 0) {
            return -1;
        }
        int[][] dp = new int[vals.length+1][capacity+1];
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(vals[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], weights[i-1] + dp[i-1][j-vals[i-1]]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[vals.length][capacity];
    }
}