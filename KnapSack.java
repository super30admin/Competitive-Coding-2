// Time Complexity : O(nw) where n is no of items and w is capacity of the bag
// Space Complexity : O(nw)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :No

class KnapSack{

    public static int knapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length; // Number of items
        int[][] dp = new int[n + 1][capacity + 1]; // DP table

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Option to include or exclude the current item
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // Exclude the current item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity]; // Maximum profit for the given capacity
    }

    public static void main(String[] args) {
        // Example input
        int[] weights = {2, 3, 4, 5};
        int[] profits = {3, 4, 5, 6};
        int capacity = 5;

        // Compute the maximum profit
        int maxProfit = knapsack(weights, profits, capacity);

        // Print the result
        System.out.println("Maximum profit: " + maxProfit);
    }


    
}