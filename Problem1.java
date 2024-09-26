
Time and Space complexity : O(n*m)

class Solution
{
    public int knapSack(int W, int wt[], int val[], int n)
    {
        int dp[][] = new int[n + 1][W + 1];
        int i, j;
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= W; j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j]
                            = Math.max(val[i - 1]
                                    + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }
}