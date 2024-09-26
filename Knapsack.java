//TIme Complexity: O(mn)
//Space Complexity: O(mn)

/*
0/1 Knapsack Problem
You are given weights and value corresponding to those weights. You want to choose the weights <= given capacity.

int[] v = {10, 40, 50, 70};
int[] w = {1, 3, 4, 5};
int c = 7;

Solution:
Math.min(dp[i - 1][j], dp[i - 1][j - weights[i-1]] + value[i-1])

                    0   1   2   3   4   5   6   7
        0   0   |   0   0   0   0   0   0   0   0
                |
    10  1   0   |   0
                |
    40  3   1   |   0
                |
    50  4   2   |   0
                |
    70  5   3   |   0

*/

public class Solution {


    public static void main(String[] args) {
        int[] v = {10, 40, 50, 70};
        int[] w = {1, 3, 4, 5};
        int c = 7;
        System.out.println(knapsack(v, w, c));
    }
    private static int knapsack(int[] value, int[] weights, int capacity) {
        // here
        if (weights.length == 0) {
            return 0;
        }

        int n = weights.length;
        int m = capacity;
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weights[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i-1]] + value[i-1]);
                }
            }
        }
        return dp[n][m];
    }
}
