// Time Complexity : O(N*W) N is the no of weight element and W is the capacity. For every weight element , we traverse through all the weight capacities.
// Space Complexity : O(N*W) - The use of 2d array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution 
{ 

   // Maximum value that can be obtained from 'n' items is the max of choosing the value i.e the value of nth item plus maximum value obtained by n-1 items and W minus the weight of nth item
   // and not choosing the value ie Maximum value obtained by n-1 items and W weight.
    
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
                     dp[i][j] = dp[i-1][j]; //weight of nth item is more than the knapsack capacity
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
