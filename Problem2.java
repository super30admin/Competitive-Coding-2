
class Knapsack {

	// Returns the maximum value that can
	// be put in a knapsack of capacity W
	static int knapSack(int W, int wt[],
						int val[], int n)
	{
		int[][] dp = new int[n+1][W+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<wt[i-1])
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
	}

	// Driver code
	public static void main(String args[])
	{
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println("Max Profit = " + knapSack(W, wt, val, n));
	}
}


