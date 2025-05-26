// TC - O(n*W)
// SC - O(n*W)
// Approach - Memoization - Create memo array and store the result of sub problems 
// so that we dont need to compute subproblems again and again which improves time 
// complexity

public class Knapsack_Memoization {

  static int helper(int W, int[] val, int[] wt, int n, int[][] memo) {

    // base case
    if (n == 0 || W == 0)
      return 0;

    // check if we have previously calculated subproblem
    if (memo[n][W] != -1)
      return memo[n][W];

    int pick = 0;

    // pick , don't pick
    if (wt[n - 1] <= W)
      pick = val[n - 1] + helper(W - wt[n - 1], val, wt, n - 1, memo);
    int nopick = helper(W, val, wt, n - 1, memo);
    memo[n][W] = Math.max(pick, nopick);
    return memo[n][W];
  }

  static int knapsack(int W, int[] val, int[] wt) {
    int n = val.length;
    int[][] memo = new int[n + 1][W + 1];

    // Initialize memoization table with -1
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++)
        memo[i][j] = -1;
    }

    return helper(W, val, wt, n, memo);
  }

  public static void main(String[] args) {
    int W = 50;
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };

    System.out.println(knapsack(W, val, wt));
  }
}
