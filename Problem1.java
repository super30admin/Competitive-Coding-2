class Solution1 {
    private static int knapsack(int[] values, int[] weights, int maxCapacity) {

        // Construct DP table
        int dp[][] = new int[weights.length + 1][maxCapacity + 1];

        // Initialize first row and first column with 0.
        // But default value of int is 0 so we can skip initialization

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (weights[i - 1] <= j) {
                    int newValue = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    // choose max value between the new value and the value in the above row
                    dp[i][j] = Math.max(newValue, dp[i - 1][j]);
                } else {
                    // same value as in the above row
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {

        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int cap = 50;

        int maxValue = knapsack(values, weights, cap);
        System.out.println(maxValue);
    }

}