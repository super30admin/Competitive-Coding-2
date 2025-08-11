/*
    Problem: 0-1 Knapsack Problem
    Approach: Bottom-Up Dynamic Programming (Iterative) + Reference Recursive Method

    Reason for NOT using recursion in the final approach:
    ----------------------------------------------------
    - A pure recursive solution for 0-1 knapsack explores all combinations, which has a
      time complexity of O(2^n) and is not feasible for large inputs.
    - Recursion also causes repeated subproblem calculations (overlapping subproblems)
      and may lead to stack overflow for big 'n'.
    - The iterative DP approach (Bottom-Up) reduces complexity to O(n*W) and uses O(W) space,
      making it much more efficient.

    Time Complexity:  O(n * W)   (n = number of items, W = capacity)
    Space Complexity: O(W)       (using 1D dp array for optimization)
    Successfully runs on LeetCode: YES
*/

class Problem1 {

    // Iterative Bottom-Up DP solution (final approach)
    static int knapsackRec(int W, int[] val, int[] wt, int n) {
        int[] dp = new int[W + 1]; // dp[j] represents max profit for capacity j

        for (int i = 0; i < n; i++) { // loop through items
            for (int j = W; j >= wt[i]; j--) { // go backwards to avoid overwriting
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }
        return dp[W];
    }

    // Recursive reference solution (for understanding only)
    // Time Complexity: O(2^n)
    static int helper(int W, int[] val, int[] wt, int n) {
        // Base case: No items left OR capacity is zero
        if (n == 0 || W <= 0) {
            return 0;
        }

        // Option 1: Pick the item (if it fits)
        int pick = 0;
        if (wt[n - 1] <= W) {
            pick = val[n - 1] + helper(W - wt[n - 1], val, wt, n - 1);
        }

        // Option 2: Don't pick the item
        int dontPick = helper(W, val, wt, n - 1);

        // Return the better of the two
        return Math.max(pick, dontPick);
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] weights = {4, 5, 1};
        int capacity = 4;

        // Iterative DP approach
        System.out.println("Max Profit (Iterative DP): " + knapsackRec(capacity, values, weights, values.length));

        // Recursive reference (not used in final solution)
        System.out.println("Max Profit (Recursive Reference): " + helper(capacity, values, weights, values.length));
    }
}