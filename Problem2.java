class Solution1 {
    public static int profit(int[] weight, int[] profit, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weight[i - 1]) {

                    dp[i][j] = dp[i - 1][j];
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int weight[] = {4, 5, 1};
        int profit[] = {1, 2, 3};
        int capacity = 4;
        System.out.println(profit(weight, profit, capacity)); 
    }
}
