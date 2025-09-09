// Time Complexity : O(m*n), where m = total items available, n = max weight of knapsack
// Space Complexity : O(m*n), can be optimized to O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Create a 2D DP matrix, with weights on the columns and item values along the rows
// Each cell [i][j] gives us the max possible value we can achieve considering the first i items and a total knapsack weight of j
// Using the pick/no pick approach, we can convert the recursion tree into matrix form
// Could not optimize space due to time constraint 

class Solution {
  public:
    int knapsack(int W, vector<int> &val, vector<int> &wt) {
        // code here
        int m = val.size();
        int n = W;
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for(int i=1; i<= m; i++){
            for(int j = 1; j<=n; j++) {
                int weight = wt[i-1];
                if(weight <= j) {
                    dp[i][j] = max(val[i-1] + dp[i-1][j-weight], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
};