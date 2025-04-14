// Knapsack 0-1: In this problem, we identify that greedy fails and then in exhaustive approach we find that there are repeated 
// subproblems. So, we go for DP. 

// Exhaustive or Recursive approach - gives time limit error
class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        return helper(capacity, val, wt, 0, 0);
    }

    private static int helper(int capacity, int val[], int wt[], int i, int profit) {
        // Base case
        // Check if we are out of weights to put in bag
        if (i >= wt.length) {
            return profit;
        }
        // Logic
        // When we do not pick the weight case
        int case0 = helper(capacity, val, wt, i + 1, profit);
        // When we pick the weight case
        int case1 = 0;
        // Check if the weight of current item is less than capacity, only then we can
        // pick the weight
        if (wt[i] <= capacity) {
            case1 = helper(capacity - wt[i], val, wt, i + 1, profit + val[i]);
        }
        // Return max of both
        return Math.max(case0, case1);
    }
}

// Using DP:
class Solution1 {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        // Declare the size of 2d DP array
        int m = wt.length;
        int n = capacity;
        // Declare dp array
        int[][] dp = new int[m + 1][n + 1];
        // Loop through the array and compute profit for each subproblem
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If capacity is less than current weight, then we only have do not pick case
                if (j < wt[i - 1]) {
                    // Do not pick case exactly above
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Else we choose max of pick and do not pick
                    // Pick case lies in above row and col is current weight steps behind the
                    // capacity
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        // Return the max profit which is in last row and last col
        return dp[m][n];
    }
}
