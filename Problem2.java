//Time complexity: O(N * W); n = length of weights array; W = capacity
//Space Complexity: O(N * W)
class Problem2
{
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        int rows = wt.length + 1;
        int cols = W + 1;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1]+dp[i - 1][j - wt[i-1]]);
                }

            }
        }
        return dp[rows-1][cols-1];
    }
}
