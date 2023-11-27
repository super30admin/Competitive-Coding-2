// Time Complexity : O(n*capacity)
// Space Complexity : O(n*capacity)
// Did this code successfully run on Leetcode : I don't have premium account, but tested in local
// Any problem you faced while coding this : -

/*
Problem::: we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.
Solution::: DP-  Use bottom up approach to solve */
public class Knapsack01 {

    public static int maxProfit(int[] profit, int[] weight, int capacity){
        if(profit.length != weight.length) return 0;
        int m = profit.length;
        int n = capacity;
        int[][] dp = new int[m+1][n+1];
        for(int i =1; i <= m; i++){
            for(int j=1; j<=n; j++){
                if(j - weight[i-1] >= 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+profit[i-1]);
                else if(j - weight[i-1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                //System.out.println(i + ":: " + j + ":::" + dp[i][j]);
            }
            //System.out.println("");
        }

        return dp[m][n];
    }

    public static void main(String args[]){
        int[] profit = new int[]{10,20,40};
        int[] weight = new int[]{1,2,5};
        int capacity = 3;
        int res = maxProfit(profit, weight, capacity);

        System.out.println("Result: " + res);
    }

}