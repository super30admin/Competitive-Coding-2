//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// Time Complexity : O(n * ksWeight)
// Space Complexity : O(n * ksWeight)
// Did this code successfully run on Leetcode : No, ran it locally
// Any problem you faced while coding this : YES


class Knapsack {

    public static void main(String[] args) {
        int weights[] = {4, 5, 1};
        int profit[] = {1, 2, 3};
        int result = getMaxProfit(4, weights, profit);
        System.out.print("result: " + result);
    }

    public static int getMaxProfit(int ksWeight, int[] weights, int[] profit) {
        int n = weights.length;   // rows
        int[][] dp = new int[n + 1][ksWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= ksWeight; j++) {
                if (weights[i - 1] <= j) {
                    // Choose max of including or excluding the current item
                    dp[i][j] = Math.max(
                            profit[i - 1] + dp[i - 1][j - weights[i - 1]], // include
                            dp[i - 1][j]                            // exclude
                    );
                } else {
                    // Cannot include the item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][ksWeight];
    }

}