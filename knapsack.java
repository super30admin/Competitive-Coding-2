class knapsack {
    //Tc: O(n*W) Sc: O(n*W)
    public static int knapSack(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n + 1][W + 1];


        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String args[]) {
        int W = 7;
        int wt[] = {1, 3, 4, 5};
        int val[] = {1, 4, 5, 7};
        int n = wt.length;

        int res = knapSack(W, wt, val, n);
        System.out.println(res);
    }
}