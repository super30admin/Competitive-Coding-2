#Time complexity: O(m*n)
#Space complexity: O(m*n)
#Leetcode: Yes

class Solution:
    def knapSack(self, capacity, val, wt):
        n = capacity + 1
        m = len(wt) + 1
        dp = [[0 for _ in range(capacity + 1)] for _ in range(len(wt) + 1)]
        for i in range(1, m):
            for j in range(1, n):
                if j < wt[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]])
        return dp[m-1][n-1]