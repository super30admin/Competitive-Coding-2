//Time Complexity : O(nW) where n -> number of elements, W -> capacity of bucket
//Space Complexity : O(nW) where n -> number of elements, W -> capacity of bucket
//Did your code run : yes
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n +1][W + 1];
         
         for(int j = 0 ; j < W; j++)
         {
             dp[0][j] = 0;
         }
         for(int i = 0 ; i < n ; i++)
         {
             dp[i][0] = 0;
         }
         
         for(int i = 1 ; i < dp.length; i++)
         {
             for(int j = 1; j < dp[0].length;j++)
             {
                 if(wt[i - 1] > j)
                 {
                     dp[i][j] = dp[i - 1][j];
                 }
                 else
                 {
                     dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                 }
             }
         }
         return dp[n][W];
    } 
}
