
// Problem 2: 0-1-knapsack-problem


public class Main {

    /**
     * Solves the 0/1 Knapsack problem using Dynamic Programming.
     * Approach: 1D Array Space-Optimized Bottom-Up DP.
     *
     * Time Complexity: O(N * W)
     * where N is the number of items and W is the maximum capacity.
     * We iterate through each item and for each item, we iterate through the capacity.
     *
     * Space Complexity: O(W)
     * Optimized from O(N * W) to O(W) by using a 1D array since the current state
     * only depends on the previous item's results.
     */

    static int knapsack(int W, int[] val, int[] wt) {

        // dp[j] stores the maximum value that can be attained with capacity j
        int[] dp = new int[W + 1];

        for (int i = 1; i <= wt.length; i++) {
            /*
             * Iterate backwards from W to wt[i-1].
             * We go backwards to ensure that each item is only used once (0/1).
             * If we went forwards, we might use the same item multiple times (Unbounded Knapsack).
             */
            for (int j = W; j >= wt[i - 1]; j--) {
                // Decision: Either keep the previous max value for this capacity,
                // or include the current item and add it to the max value of the remaining capacity.
                dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {

        int[] val = {1, 2, 13, 4 , 7};
        int[] wt = {4, 5, 1, 8 , 4};
        int W = 10;

        System.out.println(knapsack(W, val, wt));
    }
}