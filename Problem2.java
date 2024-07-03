class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         
         int[][] dp = new int[n+1][W+1];
         
         for(int j = 0; j < W+1; j++) {
             dp[0][j] = 0;
         }
         
         for(int i = 0; i < n+1; i++) {
             dp[i][0] = 0;
         }
         
         for(int i = 1; i < n+1; i++) {
             for(int j = 1; j < W+1; j++) {
                 if(j < wt[i-1]) {
                     dp[i][j] = dp[i-1][j];
                 } else {
                     dp[i][j] = Math.max(dp[i-1][j], 
                     val[i-1] + dp[i-1][j - wt[i-1]]);
                 }
             }
         }
         
         return dp[n][W];
    } 
}