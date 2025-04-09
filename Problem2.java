// Time complexity:- O(n * W)
// Space complexity:- O(W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach 
/**
 * Approach:
 * The solution uses dynamic programming to solve the 0/1 knapsack problem. 
 * A 1D dp array is used to store the maximum value possible for each weight capacity from 0 to W. 
 * For each item, we update the dp array by either including or excluding the current item to maximize the total value.
 */
 
 public class Problem2 {

    // Function to solve the Knapsack problem using Dynamic Programming
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp array in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: no item or zero capacity
                } else if (wt[i - 1] <= w) {
                    // If the current item's weight is less than or equal to the current capacity
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    // If the current item's weight is greater than the current capacity
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W]; // The bottom-right cell contains the maximum value
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};  // Values of the items
        int[] wt = {10, 20, 30};    // Weights of the items
        int W = 50;                 // Maximum weight capacity of the knapsack
        int n = val.length;         // Number of items

        // Call the knapSack function to find the maximum value that can be obtained
        int maxValue = knapSack(W, wt, val, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
