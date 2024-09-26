// for approch 1
// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : --
// Any problem you faced while coding this : no

//for approch 2
// Time Complexity : O(n*w)
// Space Complexity : O(n*w)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

class Main {

    // approch1
    public static int knapsack1(int W, int[] wt, int[] val) {

        // call helper
        return helper(0, wt, val, W, 0);
    }

    public static int helper(int ind, int[] wt, int[] val, int W, int amount) {

        // if index is at the end of the index then we return
        if (ind == val.length) {

            // if we still have weight or no weight we return maximum amount till now
            if (W >= 0) {
                return amount;
            } else {

                // else return 0 remaning weight is less than zero
                return 0;
            }
        }

        // first we take at paricular index
        int take = helper(ind + 1, wt, val, W - wt[ind], amount + val[ind]);

        // not take at particular index
        int notTake = helper(ind + 1, wt, val, W, amount);
        // System.out.println(take + " " + notTake);

        // here we are returning maximum value from taking and not taking
        return Math.max(take, notTake);

    }

    // approch 2
    public static int knapsack2(int W, int[] wt, int[] val) {
        int m = wt.length;
        int n = W;

        // initialize dp array
        int[][] dp = new int[m + 1][n + 1];

        // traverse in dp array
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // if current weight is less than maximum weight till now we save previous row
                // into current row
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {

                    // else we have two choice either take at weight at paricular index or not take
                    // if we did not take weight then we compute current maximum from previously
                    // computed maximum or we take current weight and maximum from remaining weight
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        // for(int[] d : dp){
        // System.out.println(Arrays.toString(d));
        // }

        // return maximum value;
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int W = 50;
        System.out.println(knapsack1(W, wt, val));
        System.out.println(knapsack2(W, wt, val));

    }
}