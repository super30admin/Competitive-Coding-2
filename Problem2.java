// 0-1 Knapsack Problem
/*
Given a set of n items numbered from 1 up to n, each with a weight wi and a value vi,
along with a maximum weight capacity W, maximize the sum of the values of the items in the knapsack so that
the sum of the weights is less than or equal to the knapsack's capacity.
 */
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
  public int knapSack(int capacity, int[] values, int[] weights, int n) {
    if(n == 0 || values.length == 0 || weights.length == 0 || capacity == 0) return 0;
    // Create matrix for DP
    int[][] dp = new int[n+1][capacity+1];
    // Fill values inside the matrix
    for(int i = 1; i<n+1; i++) {
      for(int j = 1; j<capacity+1; j++) {
        if(j<weights[i-1]) {
          // Copy the value above if capacity is less than weight.
          dp[i][j] = dp[i-1][j];
        }else {
          // Max between the possible values.
          dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
        }
      }
    }
    return dp[n][capacity];
  }
}