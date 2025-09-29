class Solution {
    
    private static int knapsack(int W, int[] profit, int[] weight) {
        
        if (W == 0 || weight == null || weight.length == 0) {
            return 0;
        }

        int n = weight.length;
        int[][] dp = new int[W + 1][n + 1];

        for (int i = 1; i < W + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (weight[j - 1] <= i) {
                    // max of pick and do not pick
                    dp[i][j] = Math.max(profit[j - 1] + dp[i - weight[j - 1]][j - 1], dp[i][j - 1]);
                } else {
                    // do not pick
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[W][n];
    }
    public static void main(String[] args) {
        int W = 4;
        int profit[] = new int[] {1, 2, 3};
        int weight[] = new int[] {4, 5, 1};

        System.out.println(knapsack(W, profit, weight));
        
    }
}