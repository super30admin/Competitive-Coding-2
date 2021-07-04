/* ------------------------------- KNAPSACK ------------------------------- */
// Time Complexity : O(n*m), n -> weights.length, m -> capacity
// Space Complexity : O(n*m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced few issues during the interview. With few hints, was able to figure out the solution. 

public class Problem2 {
	public int knapsack(int[] values, int[] weights, int capacity) {
		int m = values.length;
		int[][] dp = new int[m + 1][capacity + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (j < weights[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
				}
			}
		}

		return dp[m][capacity];
	}

	public static void main(String[] args) {
		Problem2 obj = new Problem2();

		int[] values = new int[] { 6, 10, 12 };
		int[] weights = new int[] { 1, 2, 3 };
		int capacity = 5;

		System.out.println("Maximum value = " + obj.knapsack(values, weights, capacity));
	}
}