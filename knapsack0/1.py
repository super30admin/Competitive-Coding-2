"""
TC ->O(n*W)
SC ->O(n*W)
Below is the tabulation method. Recursive solution will take O(2^n)
"""
class Solution:
    def knapsack(self, W, val, wt):
        n = len(val)
        dp = [[0 for _ in range(W+1)] for _ in range(n+1)]

        for i in range(1, n+1):
            for j in range(W+1):
                np = dp[i-1][j] #not pick
                p = 0
                if wt[i-1] <=j: #pick
                    p = val[i-1] + dp[i-1][j - wt[i-1]]
                dp[i][j] = max(p,np)
        return dp[n][W]