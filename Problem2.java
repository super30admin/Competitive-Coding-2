//Knapsack
// Time Complexity :O(nx2*n) 
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
public static int maxProfit(int[] weight,int[] profit,int capacity){
		if(weight.length==1)
			return profit[0];
		int[][] dp=new int[weight.length+1][capacity+1];
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++){
				if(j<weight[i-1])
				{
					dp[i][j]=dp[i-1][j];
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j],profit[i-1]+dp[i-1][j-weight[i-1]]);
				}
			}
		}

		return dp[weight.length][capacity];
	}