//The approach here is to use dp to store the previously calculated repeated subproblems
//Here we took 2d array because the output is dependent on 2 variables, weights and capacity
//Time Complexity: O(m*n) where m is the length of weights array and n is the capacity
//Space complexity: O(m*n) for the dp array
class KnapSack{
    public static int knapsack_dp(int capacity, int[] weights, int[] values) {
        int m = weights.length;
        int[][] dp = new int[m + 1][capacity + 1]; // DP table with an extra row for base case

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) { // Check if the current item can be included
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j]; // If not included, take the value from the previous row
                }
            }
        }

        return dp[m][capacity];
    }
}