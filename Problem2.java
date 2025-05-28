/*
 * Question:
 * Given weights[] and profits[] arrays, and a total weight capacity 'Cap',
 * find the maximum profit that can be obtained by selecting items such that:
 *  - Each item can be picked at most once (0/1 Knapsack)
 *  - The total weight does not exceed 'Cap'
 *
 * Approach:
 * Brute-force Solution:
 * - Try all possible combinations of taking or not taking each item.
 * - For each item at index 'i', either:
 *   → take it (if weight[i] <= remaining cap), or
 *   → skip it.
 * - Recurse this process to explore all subsets.
 * - Time Complexity: O(2^n), Space: O(n) for recursion stack
 *
 * Optimized Solution (Memoization - Top Down DP):
 * - Use a 2D memoization table: memo[i][c] stores max profit from index i with remaining capacity c
 * - Base Case: If capacity is 0 or index >= n → return profit = 0
 * - If current item's weight > capacity, skip it
 * - Else:
 *     → Option 1: take item → profit + recurse for remaining capacity
 *     → Option 2: skip item → recurse without taking it
 * - Return and store the max of both options in memo[i][c]
 *
 * Time Complexity: O(n * cap) — for n items and cap capacity values
 * Space Complexity: O(n * cap) for the memo table + O(n) recursion stack
 */

import java.util.Arrays;

public class Problem2 {
    static int[][] memo;

    static int knapsack(int[] weights, int[] profits, int Cap) {
        memo = new int[weights.length][Cap + 1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int res = helper(0, Cap, weights, profits);
        return res;
    }

    static int helper(int idx, int Cap, int[] weights, int[] profits) {
        if ((Cap == 0) || (idx >= weights.length)) {
            return 0;
        }
        if (memo[idx][Cap] != -1) {
            return memo[idx][Cap];
        }

        int take = 0;
        int notake = helper(idx + 1, Cap, weights, profits);
        if (weights[idx] <= Cap) {
            take = profits[idx] + helper(idx + 1, Cap - weights[idx], weights, profits);
        }
        memo[idx][Cap] = Math.max(take, notake);
        return memo[idx][Cap];
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30 };
        int[] profits = { 6, 100, 120 };
        int Cap = 50;
        System.out.println(knapsack(weights, profits, Cap));
    }
}