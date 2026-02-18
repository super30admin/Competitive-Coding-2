public class Problem2 {

    // Time Complexity : O(n * W_capacity)
    // Space Complexity : O(W_capacity)
    // Did this code successfully run on Leetcode : yes
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }

        return dp[W];
    }
}