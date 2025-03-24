// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
This bottom-up DP approach builds a table `dp[i][j]`,
where `dp[i][j]` represents the maximum value achievable using the first `i` items with a capacity of `
j`. If an item doesn’t fit, we carry forward the previous value.
Otherwise, we decide whether to include or exclude the item for the optimal value.
The final answer is stored in `dp[n-1][m-1]`,
 ensuring an efficient solution without redundant computations. 🚀

*/
class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        //return helper(W,val,wt,0,0);
        int m=W+1;
        int n=wt.length+1;
        int[][] dp=new int[n][m];

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if( j < wt[i-1])
                {
                    //System.out.println(i);
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j - wt[i-1]]);
                }
            }
        }

        return dp[n-1][m-1];
    }
}
