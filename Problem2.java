// Time Complexity : DP: O(N*W), , RECURSION: O(2^N)
// Space Complexity : O(N*W)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No

/**
 * Using DP, If we don't choose a weight, then we'll have to manage with the weights before it. Profit for that will be present in the row above & same column. If we choose
 * a weight, then add its weight to the profit. Now, we'll be left with (Capacity - (current weight)). The profit for this can be found row above & col = col - weight. Do this
 * for the entire matrix. Final answer will be at last row & last col.
 */

import java.util.*;
class Problem2 {
    public static void main(String args[]) {

        int[] profit = new int[]{1, 2, 3};
        int[] weight = new int[]{4, 5, 1};
        int W = 4;
        int N = 3;
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]]);
            }
        }

        System.out.println(dp[N][W]);
    }
}



/*
class Problem2{
    public static void main(String args[]) {

        int[] profit = new int[]{1, 2, 3};
        int[] weight = new int[]{4, 5, 1};
        int W = 4;
        int N = 3;

        int result = helper(weight, profit, 0, W, 0);
        System.out.println(result);
    }

    private static int helper(int[] weight, int[] profit, int i, int W, int amount)  {

        //base
        if(i == weight.length) return amount;
        if(W < 0) return amount;

        //logic
        int case0 = helper(weight, profit, i+1, W, amount);
        int case1 = helper(weight, profit, i+1, W-weight[i], amount+profit[i]);

        if(W-weight[i] < 0) return case0;

        return Math.max(case0, case1);
    }
}*/
