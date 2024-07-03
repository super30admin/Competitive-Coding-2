//Maximum Profit - 0/1 Knapsack Problem
//Time Complexity: O(n * capacity)
//Space Complexity: O(n * capacity)


public class MaxProfit {
    public int findProfit(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        if (n == 0 || capacity == 0)
            return 0;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int wts = 1; wts <= n; wts++) {
            for (int cts = 1; cts <= capacity; cts++) {
                if (weights[wts - 1] <= cts) {
                    dp[wts][cts] = Math.max(dp[wts - 1][cts], profits[wts - 1] + dp[wts - 1][cts - weights[wts - 1]]);
                } else {
                    dp[wts][cts] = dp[wts - 1][cts];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] profits = {3, 4, 5, 6};
        int capacity = 5;
        MaxProfit maxProfit = new MaxProfit();
        System.out.println("Maximum Profit is::" + maxProfit.findProfit(weights, profits, capacity));
    }
}