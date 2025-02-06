// Time Complexity : O(n*capacity)
// Space Complexity : O(n*capacity)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;

class Solution {
  public:
    int helper(int c, vector<int> &val, vector<int> &wt, int idx, vector<vector<int>>& dp) {
        //base
        if (c <= 0) return 0;
        if (idx < 0) return 0;
        if (dp[idx][c]!=-1) return dp[idx][c];
        // pick
        int case1 = 0;
        if (wt[idx] <= c) 
        { case1 = val[idx] + helper(c - wt[idx], val, wt, idx-1, dp);
        }
        // not pick
        int case2 = helper(c, val, wt, idx-1, dp);
        return dp[idx][c]= max(case1, case2);
    }
    // Function to return max value that can be put in knapsack of capacity.
    int knapSack(int capacity, vector<int> &val, vector<int> &wt) {
        // code here
        vector<vector<int>>dp(val.size()+1, vector<int>(capacity+1,-1));  
        return helper(capacity, val, wt, val.size()-1, dp);
    }
};