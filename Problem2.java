// Time Complexity :O(m*n)m is the number of weights n is capacity
// Space Complexity :O(m*n)m is the number of weights n is capacity
// Did this code successfully run on gfg : yes
// Your code here along with comments explaining your approach
// 0-1 Knapsack DP
class Solution 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n+1][W+1];
		for(int i=0;i<n+1;i++) {
			dp[i][0]=0;
		}
		for(int j=0;j<W+1;j++) {
			dp[0][j]=0;
		}
		 for(int i=1;i<dp.length;i++) {
			 for(int j=1;j<dp[0].length;j++) {
				 if(wt[i-1]<=j)dp[i][j] =Math.max(dp[i-1][j], val[i-1]+ dp[i-1][j-wt[i-1]]);
				 else dp[i][j]= dp[i-1][j];
			 }
		 }
		
		return dp[n][W];
    } 
}