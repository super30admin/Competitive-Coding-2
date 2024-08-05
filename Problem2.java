// Time Complexity: O(n*w)
// Space Complexity: O(n*w)
class HelloWorld {
    public static int knapsack(int[] weights, int[] profits, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];

    // Fill the DP table
    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            if (weights[i - 1] <= w) {
                // Choose the maximum between including and excluding the item
                dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + profits[i - 1]);
            } else {
                // Item cannot be included because it's too heavy
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    // The bottom-right cell contains the maximum profit
    return dp[n][capacity];
}
public static void main(String[] args) {
    // Example
    int[] weights = {1, 2, 3};
    int[] profits = {10, 15, 40};
    int capacity = 6;
    int maxProfit = knapsack(weights, profits, capacity);
    System.out.println("Maximum profit: " + maxProfit); // Output: Maximum profit: 55
}

}