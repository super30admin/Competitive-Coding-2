//Timecomplexity : O(m*n)
//space complexity:O(m*n)
public class Knapsack {
    static int Knapsack(int m, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4,5,1};
        int m = 4;
        int n = val.length;

        System.out.println(Knapsack(m, wt, val, n));
    }
}