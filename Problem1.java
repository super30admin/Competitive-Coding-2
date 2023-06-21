class Problem1 {

    private static int knapSack(int W, int[] weight, int[] profit, int n) {

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (weight[i - 1] <= W)
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][W - weight[i - 1]]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];

    }

    public static void main(String args[]) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
}