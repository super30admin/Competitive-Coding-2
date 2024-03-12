// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
public class Main {
    public static void main(String[] args) {
        int[] weights = new int[] { 10, 20, 30 };
        int[] profit = new int[] { 60, 100, 120 };
        int bagCapacity = 50;
        System.out.println(maxProfit(bagCapacity, weights, profit));
    }

    public static int maxProfit(int bagCapacity, int weights[], int profit[]) {
        int len = weights.length;
        int[][] dp = new int[len + 1][bagCapacity + 1];

        for (int i = 0; i <= bagCapacity; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - weights[i - 1]] + profit[i - 1]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][bagCapacity];

    }
}