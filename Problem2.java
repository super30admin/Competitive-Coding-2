// Time Complexity : O(N*W)
// Space Complexity : O(N*W)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/**
 * At every iteration, we have to see if the current capacity is
 * greater than the weight of current value, if not, then just
 * take the previous value's value else, take max of previous 
 * value's value and the sum of current value and the value calculated
 * till the previous value's value when the weight is weight -
 * weight of current value. Return last index of the dp matrix.
 *
 */
class Solution {
	// Function to return max value that can be put in knapsack of capacity W.
	static int knapSack(int W, int wt[], int val[], int n) {
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < wt[i - 1])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
			}
		}
		return dp[n][W];
	}
}