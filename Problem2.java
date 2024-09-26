// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I have used dynamic programming to solve the 0/1 knapsack problem. I create a dp array of dimensions n+1 & w+1. I fill the first row and
 * first column of the array with 0. Now I iterate through the rest of the elements and fill the value with corresponding value of the row just above
 * if wt[i-1]<j. Else I set dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1])
 */

 class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][] = new int[n+1][W+1];
         for(int i=0;i<n+1;i++)
         {
             for(int j=0;j<W+1;j++)
             {
                 if(i==0 || j==0)
                 {
                     dp[i][j]=0;
                 }
                 else if(wt[i-1]>j)
                 {
                     dp[i][j]=dp[i-1][j];
                 }
                 else
                 {
                     dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                 }
             }
         }
         return dp[n][W];
    } 
}
