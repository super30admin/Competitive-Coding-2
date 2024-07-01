// "static void main" must be defined in a public class.
/*
KnapSack problem 0/1 similar to coin change problem
 */

public class Main {

    public static void main(String[] args) {

        int[] weights = {1, 2, 3};
        int[] profits = {10, 15, 40};
        int capacity = 6;
        System.out.println(knapSack(weights, profits, capacity));

    }

    public static int knapSack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        int m = capacity;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }//if
                //case 1
                else if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }//if
                //case 2
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], profits[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }//else
            }//for
        }//for

        return dp[n][m];
    }
}
