class Solution {
    // Time Complexity : O(mn) - m is the no of weights+1 and n is the knapsack capacity+1
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public int maximumWeight(int[] wt, int[] val, int capacity) {
        if(wt.length == 0 || val.length == 0) {
            return 0;
        }
        maximumWeightHelper(wt, val, capacity);
    }

    public int maximumWeightHelper(int[] wt, int[] val, int capacity) {
        int[][] dp = new int[wt.length+1][capacity+1];

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < wt[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}