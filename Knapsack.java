// Time Complexity : O(nC) where C is capacity and n is no of items
// Space Complexity : O(nC)
// Did this code successfully run on Leetcode : NA (Not on Leetcode)
public class Knapsack {
	private static int knapSack(int W, int wt[], int val[]) {

		int[][] dp = new int[val.length + 1][W + 1];

		for (int i = 0; i <= val.length; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (wt[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				}
			}
		}
		return dp[val.length][W];
	}

	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val));
	}
}