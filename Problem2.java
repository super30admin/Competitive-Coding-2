// Time Complexity: O(N × W) N items ,W weight capacities.

// Space Complexity: O(N × W) → DP table stores values for each item-weight combination.

//Approach: 
// Create a DP table where dp[i][j] stores the max value for weight j using the first i items.
// If an item can fit, take the maximum of including or excluding it.
// The last cell dp[N-1][W] contains the optimal solution.


public class Problem2 {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int[][] dp = new int[wt.length][W+1];
        for(int i=0;i<dp[0].length;i++)
        {
            if(i>=wt[0])
            {
                dp[0][i] = val[0];
            }
            //System.out.print(dp[0][i]+"  ");
        }
        //System.out.println(" ");
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j>=wt[i])
                {
                    dp[i][j] = Math.max(dp[i-1][j],(dp[i-1][j-wt[i]]+val[i]));
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
            /*for(int j=0;j<dp[0].length;j++)
            {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println(" ");*/
        }
        return dp[wt.length-1][W];
    }
}
