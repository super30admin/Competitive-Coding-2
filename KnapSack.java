//TC: O(m*n)
//SC: O(m*n)

public class KnapSack {
    public static int knapSack(int[] weight, int[] profit, int capacity) {
        int m = weight.length; // Fix: Use length field
        int n = capacity;
        int[][] dp = new int[m + 1][n + 1]; // DP table

        // Build the DP table
        for (int i = 1; i <= m; i++) { // Start from 1 to handle base case
            for (int j = 1; j <= n; j++) { // Capacity from 1 to n
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // Cannot include current item
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return dp[m][n]; // Maximum profit
    }

    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] profit = {60, 100, 120};
        int capacity = 50;

        // Call the knapSack method and print the result
        int output = knapSack(weight, profit, capacity);
        System.out.println("Maximum Profit: " + output); // Output the result
    }
}