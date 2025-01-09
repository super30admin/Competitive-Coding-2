// TC: O ( W x n ) (capacity * totalItems)
// SC : O ( W x n )

/*
 * Use dynamic programming to compute each possible weight
 * F(i, w) = max (F(i-1, w) (not picking i), F(i - 1, w - w[i]) + val[i] (picking i))
 */
class Knapsack {
    public static int knapsackProblem(int capacity, int totalItems, int[] weights, int[] values) {
        int[][] dp = new int[totalItems + 1][capacity + 1];
        for (int i = 1; i < totalItems + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j >= weights[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[totalItems][capacity];
    }
    public static void main(String[] args) {
        int[] values = {505, 352, 458, 220, 354, 414, 498, 545, 473, 543};
        int[] weights = {23, 26, 20, 18, 32, 27, 29, 26, 30, 27};
        int n = 10;
        int W = 67;

        System.out.println(knapsackProblem(W, n, weights, values)); //1270
    }
}