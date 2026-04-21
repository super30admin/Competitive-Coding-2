class Solution {
    public int knapsack(int W, int[] val, int[] weight) {
        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                // not choose
                dp[i][j] = dp[i - 1][j];

                // choose
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        val[i - 1] + dp[i - 1][j - weight[i - 1]]
                    );
                }
            }
        }

        return dp[n][W];
    }
}