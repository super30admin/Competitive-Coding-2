// 0-1 Knapsack

// Dynamic Programming
// Time Complexity : O(n*W)
// Space Complexity : O(n*W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    static int knapSack(int W, int wt[], int val[])
    {
        int i, w;
        int n = wt.length;
        //For storing max value we can achieve for weight w (0...W)
        int dp[][] = new int[n + 1][W + 1];
  
        //Filling matrix dp[][]
        for (i = 1; i <= n; i++) 
        {
            for (w = 1; w <= W; w++) 
            {
                if (wt[i - 1] <= w) {
                    //checking if max value is attained by including i-1 or by excluding
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]],
                                        dp[i - 1][w]);
                }
                else {
                    //Excluding i-1th element as it's weight is more than the limit W
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        //Returning the max value
        return dp[n][W];
    }
  
}

// Brute Force
// Time Complexity : O(2^n)
// Space Complexity : O(1) - Should we include space used by stack for recursion?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class BruteForceSolution {

    public int knapSack(int W, int wt[], int val[], int n)
    {
        //base case
        if (n == 0 || W == 0)
            return 0;
  
        //if nth item's weight is greater than w, we exclude it.
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
  
        // Return the maximum of nth item included or not included
        else
            return Math.max( val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                            knapSack(W, wt, val, n - 1));
    }
}