/* Time Complexity: O(m*n) where m - length of weights n - capacity
 * Space Complexity: Atmost we are storing m*n subproblems so the space complexity will be O(m*n)
 * Leetcode : yes
 * Any problems : no
 */
class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    //Direct Tabulation, solved memoization in the interview.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[][] dp = new int[wt.length][capacity+1];
        for(int i=0; i<val.length; i++)
            dp[i][0] = 0;
        
        for(int i=0; i<wt.length; i++)
        {
            for(int j=1; j<=capacity; j++)
            {
                if(i==0)
                {
                    if(j>=wt[i])
                        dp[i][j] = val[i];
                    else
                        dp[i][j] = 0;
                }
                else
                {
                    if(j>=wt[i])
                        dp[i][j] = Math.max(val[i] + dp[i-1][j-wt[i]], dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wt.length-1][capacity];
    }
}