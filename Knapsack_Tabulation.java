// TC - O(n*W)
// SC - O(n*W)
// Approach - We create a 2D array of size n+1 and W+1 such that dp[i][j] stores 
// maximum value we can get. Then we will follow pick - dont pick method

public class Knapsack_Tabulation {

  static int knapsack(int W, int[] val, int[] wt) {
    int n = val.length;
    int[][] dp = new int[n + 1][W + 1];

    // build db in bottom up manner
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++) {

        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          int pick = 0;
          if (wt[i - 1] <= j) {
            // pick
            pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];

            // dont pick
            int nopick = dp[i - 1][j];

            dp[i][j] = Math.max(pick, nopick);
          }
        }
      }
    }
    return dp[n][W];
  }

  public static void main(String[] args) {
    int W = 50;
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };

    System.out.println(knapsack(W, val, wt));
  }
}
