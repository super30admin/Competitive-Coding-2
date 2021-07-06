class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int dp[][] = new int[n+1][W+1];   // dp array matrix initialization
        //rows of the dp matrix depict the weights
        for(int i=1; i<=n; i++) {
            //columns of the dp matrix define weights from 0 to total capacity of the knapsack, i.e., W
            for(int j=1; j<=W; j++) {
                if(wt[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+(dp[i-1][j-wt[i-1]]));
            }
        }
        return dp[n][W];  //returning the maximum value
         
    } 
}