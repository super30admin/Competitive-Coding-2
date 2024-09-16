public class Knapsack {

  // Recursive
  // Time Complexity : O(2^n)
  // Space Complexity : O(1)
  public int recursiveKS(int W, int wt[], int val[], int n) {
    if (n == 0 || W == 0) {
      return 0;
    }

    if (wt[n - 1] > W) {
      return recursiveKS(W, wt, val, n - 1);
    } else {
      return Math.max(val[n - 1] + recursiveKS(W - wt[n - 1], wt, val, n - 1),
          recursiveKS(W, wt, val, n - 1));
    }
  }

  // DP
  // Time Complexity: O(n*W)
  // Space Complexity: O(n*W)
  public int dpKS(int W, int wt[], int val[], int n) {
    int K[][] = new int[n + 1][W + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++) {
        if (i == 0 || W == 0) {
          K[i][j] = 0;
        } else if (wt[i - 1] <= j) {
          K[i][j] = Math.max(val[i - 1] + K[i - 1][j - wt[i - 1]],
              K[i - 1][j]);
        } else {
          K[i][j] = K[i - 1][j];
        }
      }
    }

    return K[n][W];
  }
}
