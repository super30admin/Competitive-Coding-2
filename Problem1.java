
//0-1 Knapsack Problem
//Time Complexity = O(m*n)
//Space Complexity = O(n)
public class Knapsack {

	static int knapsack(int capacity, int[] weight, int[] profit) {
		int m = weight.length;
		int n = capacity;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j < weight[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		int[] weight = { 10, 20, 30 };
		int[] profit = { 60, 100, 120 };
		int capacity = 50;

		System.out.println(knapsack(capacity, weight, profit));

	}
}
