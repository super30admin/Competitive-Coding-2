// Time complexity - O(N * M)
// Space complexity - O(N)

public class Knapsack {
    static int knapsackProblem(int capacity, int weight[], int profit[], int n) {
        if(weight == null || weight.length == 0) return 0;
        int [][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j],profit[i-1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int result = dp[n][capacity];
        return result;
    }
    public static void main(String args[])
    {
        int profit[] = new int[] { 1, 2, 6 };
        int weight[] = new int[] { 2,3,5 };
        int capacity = 8;
        int n = profit.length;
        System.out.println(knapsackProblem(capacity, weight, profit, n));
    }
}