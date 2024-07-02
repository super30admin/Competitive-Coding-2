//Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

//TC: O(N*W)
//SC: O(N*W)

/*
 * Initialize a 2D array dp where dp[i][w] represents the maximum value with i items and capacity w.
 *  Iterate through each item and capacity to update dp based on whether the current item's weight allows inclusion or not.
 *  Return dp[n][W] as the maximum achievable value with n items and capacity W.
 */
class Solution
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
         // your code here
         int dp[][] = new int [n+1][W+1];
         for(int i=0; i<=n; i++) {
             for(int w=0; w<=W; w++) {
                 if(i==0 || w==0) {
                     dp[i][w]=0;
                 } else if(wt[i-1]<=w) {
                     dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-wt[i-1]] + val[i-1]);
                 } else {
                     dp[i][w] = dp[i-1][w];
                 }
             }
         }
         return dp[n][W];
    }
}