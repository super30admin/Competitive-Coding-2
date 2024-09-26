/*this implementation uses dynamic programming to find the maximum profits
* the time complexity for this implementation is O(n)*/
public class Knapsack {
    public static int knapsack(int capacity, int[] values, int[] weights) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int capacity = 50;
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};

        int max = knapsack(capacity, values, weights);

        System.out.println("The maximum value that can be achieved is: " + max);
    }
}
