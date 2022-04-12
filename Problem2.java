/**
Problem: Knapsack: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
*/
public class Knapsack {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {

    // Base conditions
    if (profits.length == 0 || capacity == 0 || profits.length != weights.length) {
      return 0;
    }

    int dp[][] = new int[profits.length + 1][capacity + 1];

    // Profit is 0 when capacity is 0
    // Profit is 0 when item is 0
    for (int i = 1; i <= profits.length; ++i) {
      for (int c = 1; c <= capacity; ++c) {
        if (weights[i-1] <= c) {
          dp[i][c] = Math.max(profits[i-1] + dp[i-1][c-weights[i-1]], dp[i-1][c]);
        } else {
            dp[i][c] = dp[i-1][c];
        }
      }
    }
    return dp[profits.length][capacity];
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = {1, 2, 3, 6};
    int[] weights = {1, 2, 3, 4};
    System.out.println("Max profit: " + ks.solveKnapsack(profits, weights, 4));
  }
}