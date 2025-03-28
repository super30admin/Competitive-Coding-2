//0-1 Knapsack problem
//Time complexity - O(m*n) where m=no of items given, n=capacity of knapsack
//Space complexity - O(m*n)
//Did it run leetcode - Yes
//Approach - One int dp[m+1][n+1] matrix to store profits. 0th row and 0th row col should be kept 0. if capacity less than wt of item -> no choose case and value come as it is from above row. else in choose case option, value is max of no choose case and profit for that item + profit of remaining wt if choose, like max(profit[i-1]+ dp[i-1][j-wt[i-1]], dp[i-1][j]), final output is in dp[m][n] after loop

public class Knapsack {
    private static int helper(int[] wt, int[] profit, int W, int i, int totalProfit) {
        //base case
        if(i >= wt.length) {
            return totalProfit;
        }

        //choose case
        int choose = 0;
        if(wt[i] <= W) {
            choose = helper(wt, profit, W - wt[i], i+1, totalProfit + profit[i]);
        }

        //no choose case
        int noChoose = helper(wt, profit, W, i+1, totalProfit);

        return Math.max(choose, noChoose);
    }

    private static int zeroOneKnapSack(int[] wt, int[] profit, int W) {
        int m = wt.length;
        int n = W;
        int[][] dp = new int[m+1][n+1];

        //default values will be zero so no need to explicitly mark 0th row and 0th column values as 0

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(j < wt[i - 1]) {
                    //capacity less than wt of item -> no choose case
                    dp[i][j] = dp[i-1][j];
                } else {
                    //choose option
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt[i-1]] + profit[i-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] profit = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;

        System.out.println("Maximum profit for example 1: " + zeroOneKnapSack(wt, profit, W));
        System.out.println("Maximum profit for example 1 with BruteForce: " + helper(wt, profit, W, 0, 0)); //index and current profit is also passed
    }
}