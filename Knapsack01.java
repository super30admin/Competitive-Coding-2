// Idea is to use pick and no pick elements to fill the knapsack
// Use bottom up - DP array to store sub problem results and use them to solve larger problems  
// Time Complexity: O(n)
// Space Complexity: O(n)
public class Knapsack01{

        public int knapsack(int W, int[] val, int[] wt,int index) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                // If there is no item or the knapsack's capacity is 0
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    int pick = 0;
                    // Pick ith item if it does not exceed the capacity of knapsack
                    if (wt[i - 1] <= j)
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    int notPick = dp[i - 1][j];
                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][W];
        }
}