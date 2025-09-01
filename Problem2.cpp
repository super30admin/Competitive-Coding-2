// Problem - 0-1 Knapsack
//  Time Complexity : O(n)
//  Space Complexity : O(n*W)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We take a 2D matrix to store intermediate results;
// 2. If we have a weight that is less than equal to our capacity, then only we
// take the max between the row above and curr_value + previous_row's
// current_weight - capacity of curr value
// 3. And in the  end we return the last row and col value which stores our sum
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int knapsack(int W, vector<int> &val, vector<int> &wt) {
    // code here
    int m = (int)wt.size();
    int n = W;
    vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (wt[i - 1] <= j) {
          dp[i][j] = max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[m][n];
  }
};
