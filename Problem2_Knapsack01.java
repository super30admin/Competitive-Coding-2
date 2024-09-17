// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on GeeksforGeeks : Yes
// Any problem you faced while coding this : No
public class Problem2_Knapsack01 {

	public static void main(String[] args) {
		int val[] = new int[] { 10, 15, 40 };
        int wt[] = new int[] {1, 2, 3};
        int W = 6;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub
		int [][] dp=new int[n+1][w+1];
		
		 for(int j=1;j<=w;j++)
         {
             dp[0][j]=0;
         }
		 
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=w;j++)
			{
				if(j<wt[i-1])
				{
					dp[i][j]=dp[i-1][j];
				}
				else
				{
					dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
				}
			}
		}
		return dp[n][w]==w+1?-1:dp[n][w];
	}
}
