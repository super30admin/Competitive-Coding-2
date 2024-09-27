//0-1 Knapsack Problem

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach



static int knapSack(int W, int wt[], int val[], int n)
{
        //Null Case
    if(W == 0 || wt.length == 0)   return 0;
    // your code here

    int[][] dp = new int[n+1][W+1];
            
    for(int i = 0; i < dp.length; i++){
        for(int j = 0; j< dp[0].length; j++){
            if(i == 0 || j == 0 ){
                dp[i][j] = 0;
            }
            else if(j < wt[i-1]){
                dp[i][j] = dp[i-1][j];
            }else{
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt[i-1]] + val[i-1]);
        }
    }
    return dp[n][W];
}