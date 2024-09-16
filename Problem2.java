/*
 *TC : O(max * n) where n is the length of the input array of weights/values
 SC :O(max * n) for the matrix
Did this code successfully run on Leetcode :
Any problem you faced while coding this : No
 *
 *
 */

/**
 * The approach taken is to construct a 2d matrix and use dp to solve. At any index,
 * we take the max for two choices, to choose current element or not to choose.
 * For choosing, the value comes from "total value till the total weight = weight - current weight"  + current value
 * For not choosing, it is simply the value above, ie the value comes from "value untill not choosing
 */
public int knapsack(int[] weights, int[] values, int max)
        {
        int[][] dp = new int[weights.length][max+1];

        dp[0][0]=0;


        if (max <= 0 || values.length == 0 || weights.length != values.length)
            return 0;

        for(int j=0; j< dp[0].length; j++)
        {
           dp[0][j]=1;
        }

        for(int i=0; i< dp.length; i++)
        {
          dp[i][0]=0;
        }

        for(int i=1; i<dp.length;i++)
        {
          for(int j=1; j<dp[0].length;j++)
             {
            if(j < weights[i])
                dp[i][j] = dp[i-1][j];

             else
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
        }