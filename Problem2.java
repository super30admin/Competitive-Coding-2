/**
 * Time complexity: O(mn)
 * Space complexity: O(mn)
 * 
 * Approach: We consider one item at a time and increase knapsack capacity upto
 * limit.
 * If the current item weight is less than knapsack capacity, we check what
 * gives the highest value.
 * Adding it or excluding it and store the maximum value in the table.
 * In case the current item is too heavy to be added, we use the previously
 * calculated value
 * at the current capacity where the current item is not considered.
 */

class Problem2 {
  public int knapsack(int[] weights, int[] values, int capacity) {
    int m = weights.length;
    int n = capacity;
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (weights[i - 1] <= capacity) {
          int valueWithWeight = values[i - 1] + dp[i - 1][capacity - weights[i - 1]];
          int valueWithoutWeight = dp[i - 1][j];
          dp[i][j] = Math.max(valueWithWeight, valueWithoutWeight);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[m][n];
  }
}