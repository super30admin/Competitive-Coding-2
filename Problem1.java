//  0/1 Knapsack Problem
class Problem1 {
    public int helper(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30, 35 };
        int[] values = { 60, 100, 120, 240 };
        int capacity = 50;
        Problem1 obj = new Problem1();
        System.out.println(" Maximum Value possible: " + obj.helper(weights, values, capacity));
    }
}