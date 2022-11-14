public class Solution {
    public int knapsackProblem(int[] values, int[] weights, int capacity) {

        if (values == null || values.length == 0) {
            return 0;
        }

        if (weights == null || weights.length == 0) {
            return 0;
        }

        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j > i) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - i] + weights[i - 1]);
                }

            }
        }

        return dp[n][capacity];
    }

}

class Main {
    public void main(String args[]) {
        int[] values = new int[] { 60, 100, 120 };
        int[] weights = new int[] { 10, 20, 30 };
        int W = 50;

        Solution k = new Solution();
        int hi = k.knapsackProblem(values, weights, W);
        System.out.println(hi);
    }
}