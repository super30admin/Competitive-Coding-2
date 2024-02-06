// Knapsack 0-1
// Time Complexity: O(n*W)
// Space Complexity :O(n*W) 

class Solution
    {
        public int knapSack(int W, int[] wt, int[] val,int n)
        {
            int[][] dp = new int[n + 1][];
            dp[0] = new int[W + 1];
            for(int i = 1; i <= n; i++) {
                dp[i] = new int[W + 1];
                for(int j = 0; j <= W; j++) {
                    // We use i-1 to account for the extra row at the top
                    if(j < wt[i-1]) {
                        // Copy previous item's value to current row until j = current item's weight
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        // get max value between previous item's value at 'j' and sum of current item's value and previous
                        // item's value with the remaining capacity (j-wt[i-1])
                        dp[i][j] = Math.Max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                    }
                }
            }
            return dp[n][W];
        }
    }