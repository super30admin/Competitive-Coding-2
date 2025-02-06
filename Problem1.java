// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class KnapSackProblem {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int wtLen = wt.length;
        // code here
        int[][] dp = new int[wtLen + 1][capacity + 1];

        for (int i = 1; i <= wtLen; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i-1] + dp[i-1][j - wt[i-1]]);
                }
            }
        }
        return dp[wtLen][capacity];
    }
}