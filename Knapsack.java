
// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
import java.util.Arrays;

class knapsack {
	/*
	 * In this function, we create a dp 2D array, where we store the max value that
	 * can be obtained at each iteration of maximum weight W, and in the end we
	 * return the last element present in last row and last column of 2D array
	 */
	public static int knapSack(int W, int wt[], int val[], int n) {
		int dp[][] = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				} else if (j - wt[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][W];
	}

	public static void main(String[] args) {
		int val[] = new int[] { 1, 4, 5, 7 };
		int wt[] = new int[] { 1, 3, 4, 5 };
		int W = 7;
		int n = val.length;
		int max_value = knapSack(W, wt, val, n);
		System.out.println("Weights: " + Arrays.toString(wt));
		System.out.println("Value: " + Arrays.toString(val));
		System.out.println("Weight Capacity: " + W);
		System.out.println("Maximum Value: " + max_value);
	}
}