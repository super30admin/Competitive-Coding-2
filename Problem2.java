//Time = O(n*w), n is number of items and w is max weight(capacity of knapsack)
//Space = O(n*w)

public class Knapsack {

    // Function to solve the 0/1 Knapsack problem
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        
        // Build the dp array from bottom up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // The maximum value that can be obtained with the given weight capacity W
        return dp[n][W];
    }