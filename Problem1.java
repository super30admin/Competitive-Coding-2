//Time Complexity: O(m*n)
// Space Complexity : O(m*n)
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n+1][W+1];
        for(int i = 1; i <=n ; i++){
            for(int j = 1; j <= W; j++){
                if(j < wt[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                
            }
        }
        return dp[n][W];
    } 
}