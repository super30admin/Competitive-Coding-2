
/*
Time: O(weights*capacity)
Space: O(weights*capacity)
*/

public class Knapsack {

    public static int getMaxValue(int[] weights, int[] values, int capacity) {
        System.out.println(" Inside getMaxValue function ");

        if (weights.length == 0 || weights == null)
            return 0;

        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {

                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][capacity];
    }

    public static void main(String[] args) {
        System.out.println(" class Solution - Inside Main");
        int[] values = { 100, 200, 300 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;
        System.out.println(getMaxValue(weights, values, capacity));

    }

}
