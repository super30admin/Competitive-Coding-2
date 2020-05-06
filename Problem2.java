
public class houseRobber {

	private static int robber(int[] w, int[] v, int maxCapacity)
	{
		//edge case
		if(w== null|| w.length==0 || v.length==0 || v== null|| maxCapacity ==0) return 0;

		//logic
		int[][] dp = new int[w.length+1][v.length];


		for(int i =0; i <= v.length; i++)
		{
			for(int j =0; j<= dp.length; j++)
			{
				if (i==0 || j==0) 
					dp[i][j] = 0; 

				else if (w[i-1] <= j) 
				{
					dp[i][j] = Math.max(dp[j-1][i], v[j-1] + dp[i-1][i-w[j-1]]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}

			}

		}

		return dp[w.length][maxCapacity];
	}

	public static void main(String args[])
	{
		int[] weights = {1,2,3,5};
		int[] values = {30,70,50,60};
		int maxCapacity = 5;

		int maxValue = robber(weights,values, maxCapacity);
		System.out.print(maxValue);
	}
}


