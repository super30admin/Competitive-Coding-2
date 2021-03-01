// Time Complexity : O(n * capacity)
// Space Complexity : O(n * capacity)

public class Knapsack {
    public static int max(int[] weights, int[] value, int capacity) {
        if (weights.length == 0 || value.length == 0 || capacity == 0)
            return 0;
        int n = value.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= capacity; c++) {
                if (weights[i - 1] <= c) {
                    dp[i][c] = Math.max(value[i - 1] + dp[i - 1][c - weights[i - 1]], dp[i - 1][c]);
                } else {
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30 };
        int[] value = { 60, 100, 120 };
        int capacity = 50;

        System.out.println(max(weights, value, capacity));
    }
}
