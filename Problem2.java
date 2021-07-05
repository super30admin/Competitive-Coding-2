//Problem 2: 0-1 Knapsack problem

//Time Complexity : O(n*m)
//Space Complexity : O(n*m)

public class KnapSack {

	public static void main(String[] args) {
		int[] values = { 60, 100, 120 };// values associated with each weight
		int[] weight = { 10, 20, 30 };// weights available
		int w = 50;// max weight a knapsack can weigh

		// declaring a dp array with corressponding rows and columns
		int m = weight.length + 1;
		int n = w / 10 + 1;
		int[][] dp = new int[m][n];

		// iterating through the dp array to find the final optimal solution
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (weight[i - 1] > j * 10) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weight[i - 1] / 10], dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[m - 1][n - 1]);

	}

}
