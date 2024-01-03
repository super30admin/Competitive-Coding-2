// Time Complexity : O(n) 
// Space Complexity : 0(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


    class Solution 
    { 
        //Function to return max value that can be put in knapsack of capacity W.
        static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
       int [][] dp = new int[n+1][W+1];
      
          
           for(int i=0; i<=n; i++)
           {
               for(int j=0; j<=W; j++)
               {   
                   if(i == 0 || j == 0) dp[i][j] = 0;
                   else if(j >= wt[i-1])
                   {
                       dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                   }
                   else
                    dp[i][j] = dp[i-1][j];
               }
           }
           return dp[n][W];
    } 
    }
    
    
    