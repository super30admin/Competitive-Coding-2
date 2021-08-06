class Knapsack {

	static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}

	// Returns the maximum value
	static int knapSack(int W, int wt[],
						int val[], int n)
	{
		int i, w;
		int dp[][] = new int[n + 1][W + 1];

		//  dp[][] array 
		for (i = 0; i <= n; i++)
		{
			for (w = 0; w <= W; w++)
			{
				if (i == 0 || w == 0)
					dp[i][w] = 0;
				else if (wt[i - 1] <= w)
					dp[i][w]
						= max(val[i - 1]
						+ dp[i - 1][w - wt[i - 1]],
						dp[i - 1][w]);
				else
					dp[i][w] = dp[i - 1][w];
			}
		}

		return dp[n][W];
	}

	// Driver code
	public static void main(String args[])
	{
		int val[] = new int[] { 2, 3, 5 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}