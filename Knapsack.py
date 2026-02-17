# Time Complexity : O(m * n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Use 1D array to keep track of max profit for every capacity.

class Solution:
    def knapsack(self, W, val, wt):
        n = W
        m = len(wt)
        dp = [0] * (n+1)
        
        for i in range(m):
            for j in range(n, wt[i] - 1, -1):
                dp[j] = max(dp[j], val[i] + dp[j - wt[i]])

        return dp[n]
