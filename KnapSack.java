public class KnapSack {
    public int knapSack(int W, int wt[], int val[], int n) {
        if (val == null || n == 0) {
            return 0;
        }
        int[][] dp = new int[wt.length + 1][W + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }

            }
        }
        return dp[wt.length][W];
    }

    public static void main(String[] args) {
        KnapSack knapSack = new KnapSack();
        System.out.println(knapSack.knapSack(4, new int[] { 4, 5, 1 }, new int[] { 1, 2, 3 }, 3));
    }
}