// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
public class FindMaxProfitWithDP {
	
	public static int findMax(int[] items, int[] profit, int totalCapacity)
	{
		int n = totalCapacity/10;
		int m = items.length;
		int[][]  dp = new int[m+1][n+1];
		
		for(int i = 1; i <= m; i++ )
		{
			for(int j = 1; j <= n ; j++)
			{
				if(i == j)
				{
					dp[i][j] = Math.max(profit[i-1],dp[i-1][j]);
				}else if(i > j)
				{
					dp[i][j] = dp[i-1][j];
				}else {							
					dp[i][j] = Math.max(dp[i-1][j] , profit[i-1]+dp[i-1][j-i]);
				}
			}
		}
		return dp[m][n];
		
	}
	
	public static void main(String args[])
	{
		int[] items = {10,20,30,40};
		int[] profit = {130,110,170,190};
		int capacity = 50;
	
		System.out.println(findMax(items, profit, capacity));
	}
}
