/* Time Complexity : O(M * N), where M = weight array length and N = W
   Space Complexity : O(M * N)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Method: DP
*/


class Solution
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[wt.length+1][W+1];
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                if(j>=wt[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}