// 0-1 Knapsack via bottom-up DP: dp[i][j] = max value using first i items within capacity j.
// For each item i and capacity j: if wt[i-1] > j -> can't take -> carry dp[i-1][j];
// else choose max of skipping (dp[i-1][j]) vs taking once (profit[i-1] + dp[i-1][j - wt[i-1]]).
// Time O(m*n)
// Space O(m*n)

class Solution {
	
	public static int findMax(int[] weights, int[] profit, int totalCapacity)
	{
		int n = totalCapacity;
		int m = weights.length;
		int[][]  dp = new int[m+1][n+1];
		
		for(int i = 1; i <= m; i++ )
		{
			for(int j = 1; j <= n ; j++)
			{
				 if(weights[i-1] > j)
				{
					dp[i][j] = dp[i-1][j];
				}else {							
					dp[i][j] = Math.max(dp[i-1][j] , profit[i-1]+dp[i-1][j-weights[i-1]]);
				}
			}
		}
		return dp[m][n];
		
	}
}