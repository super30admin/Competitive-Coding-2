class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                int weight = wt[i - 1];
                int value = val[i - 1];

                if (weight > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight] + value);
                }
            }
        }
        return dp[n][W];
    }
}
