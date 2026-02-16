import java.util.Arrays;

// Recursive O(2^n) time, O(n) space
// class Solution {
//     public int knapsack(int W, int val[], int wt[]) {
//         return helper(0, val, wt, W);
//     }

//     public int helper(int i, int[] val, int[] wt, int W) {
//         if (i == val.length || i == wt.length) {
//             return 0;
//         }
//         if (W == 0) { // base case
//             return 0;
//         }

//         int pick = 0;
//         if (wt[i] <= W) {
//             pick = val[i] + helper(i+1, val, wt, W - wt[i]);
//         }
//         int dontPick = helper(i+1, val, wt, W);

//         return Math.max(pick, dontPick);
//     }
// }

// Top down memo O(n * W) time, O(n * W) space

// class Solution {
//     public int knapsack(int W, int val[], int wt[]) {
//         int n = val.length;
//         int[][] dp = new int[n + 1][W + 1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return helper(0, val, wt, W, dp);
//     }

//     public int helper(int i, int[] val, int[] wt, int W, int[][] dp) {
//         if (i == val.length || i == wt.length) {
//             return 0;
//         }
//         if (W == 0) { // base case
//             return 0;
//         }

//         if (dp[i][W] != -1) return dp[i][W];

//         int pick = 0;
//         if (wt[i] <= W) {
//             pick = val[i] + helper(i+1, val, wt, W - wt[i], dp);
//         }
//         int dontPick = helper(i+1, val, wt, W, dp);

//         dp[i][W] = Math.max(pick, dontPick);
        
//         return dp[i][W];
//     }
// }

// Bottom up tabulation O(n * W) time, O(n * W) space
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int w = 0; w <= W; w++) {
            dp[0][w] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i-1] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], val[i-1] + dp[i-1][w - wt[i-1]]);
                }
                else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][W];
    }
}