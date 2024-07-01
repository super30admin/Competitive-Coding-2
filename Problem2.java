// Time Complexity : O(N*W) + O(n) for recursive stack
// Space Complexity : O(N*W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Memoization

import java.util.Arrays;

class Solution {

    // Helper function to solve the knapsack problem using recursion and memoization
    private static int helper(int W, int wt[], int val[], int n, int[][] memoDp) {
        // Base condition: if no items are left to check
        if (n < 0) return 0;

        // Check if the subproblem has already been solved
        if (memoDp[n][W] != -1) return memoDp[n][W];

        // Do not pick the current item
        int notpick = helper(W, wt, val, n - 1, memoDp);

        // Initialize the value for picking the current item to the minimum possible value
        int pick = Integer.MIN_VALUE;

        // If the current item's weight is less than or equal to the remaining capacity
        if (W >= wt[n]) {
            // Pick the current item and add its value, then solve the subproblem with reduced capacity and one less item
            pick = val[n] + helper(W - wt[n], wt, val, n - 1, memoDp);
        }

        // Memoize the result of the current subproblem
        return memoDp[n][W] = Math.max(notpick, pick);
    }

    // Function to return max value that can be put in knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n) {
        // Initialize the memoization array with -1
        int[][] memoDp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memoDp[i], -1);
        }

        // Call the helper function with initial parameters
        return helper(W, wt, val, n - 1, memoDp);
    }
}

// Time Complexity : O(N*W)
// Space Complexity : O(N*W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//dp tabulation


class Solution 
{ 
    // Function to return the maximum value that can be put in a knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        // Create a 2D array dp where dp[i][j] represents the maximum value that can be achieved
        // with the first i items and a knapsack capacity of j.
        int[][] dp = new int[n + 1][W + 1];

        // Iterate over each item (including a dummy item at index 0)
        for (int item = 0; item <= n; item++)
        {
            // Iterate over each possible weight from 0 to W
            for (int currentWeight = 0; currentWeight <= W; currentWeight++)
            {
                // Base case: If there are no items or the capacity is 0, the maximum value is 0.
                if (item == 0 || currentWeight == 0) {
                    dp[item][currentWeight] = 0;
                }
                // If the weight of the current item is less than or equal to the current capacity
                else if (wt[item - 1] <= currentWeight) {
                    // Either include the current item or exclude it, and take the maximum value.
                    dp[item][currentWeight] = Math.max(val[item - 1] + dp[item - 1][currentWeight - wt[item - 1]], dp[item - 1][currentWeight]);
                }
                // If the weight of the current item is greater than the current capacity, exclude the item.
                else {
                    dp[item][currentWeight] = dp[item - 1][currentWeight];
                }
            }
        }
        // The value at dp[n][W] will be the maximum value that can be achieved with n items and a capacity of W.
        return dp[n][W];
    } 
}
