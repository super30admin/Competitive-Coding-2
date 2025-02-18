// Time Complexity : O(n*w)
// Space Complexity : O(w)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Knapsack {
    public static int knapSack(int W, int[] wt, int[] val) {
        int items = wt.length;
        int[][] dp = new int[items + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= items; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[items][W];
    }

    // Driver Code
    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        System.out.println(knapSack(W, weight, profit));
    }
}