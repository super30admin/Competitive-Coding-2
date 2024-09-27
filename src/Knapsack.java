/*
 * Please find below DP solution. 
 * Complexity of the algorithm is O(m*n)
 * where m is capacity and the n is weights.
 */
public class Knapsack {
	// "static void main" must be defined in a public class.

	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {

		int finalAmount = 0;

		int[][] dp = new int[n + 1][w + 1];

		for (int i = 1; i < dp.length; i++) {

			for (int j = 1; j < dp[0].length; j++) {

				if (j < wt[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];

	}
}
