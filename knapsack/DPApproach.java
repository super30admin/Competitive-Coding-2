package knapsack;

//Time Complexity : O(noOfItems*weight)
//Space Complexity : O(noOfItems*weight)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

public class DPApproach {

    public static void main(String[] args) {

        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;

        int m = weight.length;
        int n = capacity;

        int[][] dp = new int[m + 1][n + 1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {

                if(j < weight[i-1]) {
                    dp[i][j] = dp[i-1][j];  // no choose
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], profit[i-1] + dp[i-1][j - weight[i-1]]);
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
