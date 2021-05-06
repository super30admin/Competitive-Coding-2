class Solution 
{ 
    //KNAP SACK
    //Time O(m*n)
    //Space O(m*n)
    /*
    Intutuion : Since choosing a coin binary so while choosing a weight we need to take a max of dp[i-][j] i.e not chose curr or chhose it val[i-1] + dp[i-1][j-wt[i-1]] 
    */
    public static int knapSack(int W, int wt[], int val[], int n) 
    { 
         if(wt == null || wt.length == 0)
         {
             return -1;
         }
         int dp[][] = new int[wt.length+1][W+1];
         for(int i=1 ; i<dp.length ; i++)
         {
             for(int j=1 ; j<dp[0].length ; j++)
             {
                 if(wt[i-1] > j)
                 {
                     dp[i][j] = dp[i-1][j];
                 }
                 else
                 {
                     dp[i][j] = Math.max(dp[i-1][j] , val[i-1] + dp[i-1][j-wt[i-1]]);
                 }
             }
         }
         return dp[dp.length-1][dp[0].length-1];
    }

}


