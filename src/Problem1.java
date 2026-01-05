import java.util.Arrays;

/*
0/1 KNAPSACK (DP-10)

Problem:
Given arrays values[] and weights[] for n items and capacity W, return the maximum total value
such that total weight <= W. Each item can be taken at most once (0/1 property).

Approaches included in this file:
1) Pure Recursion (exponential) – for understanding
2) Top-Down DP (Memoization) – cache (index, capacity)
3) Bottom-Up DP (2D Tabulation) – classic dp table
4) Bottom-Up DP (1D Optimized) – space optimized, iterate capacity backwards

Time Complexity:
- Recursion: exponential
- Top-Down: O(n * W)
- Bottom-Up 2D: O(n * W)
- Bottom-Up 1D: O(n * W)

Space Complexity:
- Top-Down: O(n * W) + recursion stack O(n)
- Bottom-Up 2D: O(n * W)
- Bottom-Up 1D: O(W)
*/

public class Problem1 {
    private int[][] memo;

    /* 1) PURE RECURSION (slow, for understanding)*/
    public int maxValueRecursive(int[] values, int[] weights, int W) {
        if (values == null || weights == null || values.length != weights.length) return -1;
        return rec(values, weights, 0, W);
    }

    private int rec(int[] values, int[] weights, int index, int cap) {
        if (index == values.length || cap == 0) return 0;

        // skip
        int skip = rec(values, weights, index + 1, cap);

        // take (if fits)
        int take = 0;
        if (weights[index] <= cap) {
            take = values[index] + rec(values, weights, index + 1, cap - weights[index]);
        }

        return Math.max(skip, take);
    }

    /* 2) TOP-DOWN DP (Memoization)
       memo[index][cap] = max value from index..end with capacity cap
     */
    public int maxValueTopDown(int[] values, int[] weights, int W) {
        if (values == null || weights == null || values.length != weights.length) return -1;

        int n = values.length;
        memo = new int[n][W + 1];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        return topDown(values, weights, 0, W);
    }

    private int topDown(int[] values, int[] weights, int index, int cap) {
        if (index == values.length || cap == 0) return 0;
        if (memo[index][cap] != -1) return memo[index][cap];

        int skip = topDown(values, weights, index + 1, cap);

        int take = 0;
        if (weights[index] <= cap) {
            take = values[index] + topDown(values, weights, index + 1, cap - weights[index]);
        }

        memo[index][cap] = Math.max(skip, take);
        return memo[index][cap];
    }

    /* 3) BOTTOM-UP DP (2D Tabulation)
       dp[i][w] = max value using first i items with capacity w */
    public int maxValueBottomUp2D(int[] values, int[] weights, int W) {
        if (values == null || weights == null || values.length != weights.length) return -1;

        int n = values.length;
        int[][] dp = new int[n + 1][W + 1];

        // dp[0][w] = 0 (no items)
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                // skip item i-1
                dp[i][w] = dp[i - 1][w];

                // take item i-1 if it fits
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w],
                            values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                }
            }
        }

        return dp[n][W];
    }

    /* 4) BOTTOM-UP DP (1D Optimized)
       dp[w] = max value with capacity w (processed items so far)*/
    public int maxValueBottomUp1D(int[] values, int[] weights, int W) {
        if (values == null || weights == null || values.length != weights.length) return -1;

        int n = values.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
            }
        }

        return dp[W];
    }
}
