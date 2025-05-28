public class Solution {
    public int knapsack(int[] weights, int[] values, int W, int n) {
        // Handle edge cases
        if (n == 0 || W == 0) {
            return 0;
        }
        
        // Initialize DP table
        int[][] dp = new int[n + 1][W + 1]; // Snippet 1
        
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i-1] <= w) {
                    // Include or exclude item
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w - weights[i-1]], dp[i-1][w]);
                } else {
                    // Exclude item
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        
        return dp[n][W]; // Snippet 3
    }
}