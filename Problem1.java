/*
Given 2 arrays weights and profits and capacity - find max profit
ex: int[] weights = { 10, 20, 30 };
    int[] preofits = { 60, 100, 120 };
    int capacity = 50;
    output : 220
    indices relate weights and profits
 */
class Problem1 {

    public static int weightsAndCapacity(int[] weights, int[] profits, int capacity) {
        if (weights == null || weights.length == 0 || profits == null || profits.length == 0 || weights.length != profits.length) {
            return -1;
        }
        int maxProfit = Integer.MIN_VALUE;
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {


                    int prev = dp[i - 1][j];
                    int curr = profits[i - 1] + dp[i - 1][j - weights[i - 1]];

                    dp[i][j] = Math.max(prev, curr);
                }
                maxProfit = Math.max(maxProfit, dp[i][j]);

            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] preofits = {60, 100, 120};
        int capacity = 50;

        System.out.println(weightsAndCapacity(weights, preofits, capacity));
    }

}