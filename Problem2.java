// Approach:
// Use 1D dynamic programming to solve the 0/1 Knapsack problem.
// Iterate over each item, and for each weight from W to item's weight,
// update dp[j] as the max of not taking or taking the current item.
// We traverse from right to left to prevent overwriting the results
// needed for the current iteration.

// Time Complexity : O(n * W) where n = number of items, W = knapsack capacity
// Space Complexity : O(W) - Optimized from 2D to 1D DP array
// Did this code successfully run on Leetcode : Not applicable (runs in local/test environment)
// Any problem you faced while coding this : No

import java.util.*;

class Solution {

    // Function to find the maximum profit
    static int knapsack(int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1]; // dp[j] represents max value with capacity j

        for (int i = 1; i <= wt.length; i++) {
            // Traverse in reverse to use previous row's values
            for (int j = W; j >= wt[i - 1]; j--) {
                // Choose max of not taking or taking the item
                dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
            }
        }

        return dp[W]; // Max profit with full capacity
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        System.out.println(knapsack(W, val, wt)); // Output: 3
    }
}
