
"""

Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated 
with n items respectively. Also given an integer W which represents knapsack capacity, 
find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

"""

# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on geeksforgeeks : Yes
# Any problem you faced while coding this : No

class Solution:
    def knapSack(self, W, wt, val, n):

        if n == 0 or len(n) < 1:
            return -1

        dp = [[0 for x in range(W + 1)] for x in range(n + 1)]
    
    
        for i in range(n + 1):
            for j in range(W + 1):
                if i == 0 or j == 0:
                    dp[i][j] = 0
                elif wt[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j])


        result = dp[n][W]
        return result


