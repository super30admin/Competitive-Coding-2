// 0-1 Knapsack Problem
// Time Complexity: O(n*m) where n is the length of array weights and m is the capacity
// Space Complexity: O(n*m) where n is the length of array weights and m is the capacity
public class Problem1 {
    public static void main(String[] args) {
        int[] values = new int[] { 60, 100, 120 };
        int[] weights = new int[] { 10, 20, 30 };
        int capacity = 50;

        System.out.println(getMaxValueKnapsack(values, weights, capacity));
    }

    static int getMaxValueKnapsack(int[] values, int[] weights, int capacity) {
        int n = weights.length;
        int m = capacity;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // if current weight is less than or equal to current capacity
                if (weights[i - 1] <= j) {
                    // update value
                    dp[i][j] = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                }
                else {
                    // use existing value
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}