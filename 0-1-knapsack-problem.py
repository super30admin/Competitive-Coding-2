# Time Complexity : O(n*W) - n is length of wt
# Space Complexity : O(n*W) - n is length of wt
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
So, fill the bag, we either pick a weight or we do not pick a weight.
We return the profit as max(picking weight, not picking weight)

Recursion

Base condition:

if W == 0 or i == n : return 0
if wt[i] > W: return self.helper(W, wt, val, i + 1)
else : return max (val[i] + knapSack(W-wt[i], wt, val, i + 1)),
             knapSack(W, wt, val, i + 1)
"""




class Solution(object):
    # Returns the maximum value that
    # can be put in a knapsack of capacity W
    def knapSack(self, W, wt, val):

        n = len(wt)
        dp = [[0 for i in range(0, 1 + W)] for i in range(0, n + 1)]

        for i in range(0, n + 1):
            for j in range(0, W + 1):
                if i == 0 or j == 0:
                    dp[i][j] = 0
                elif wt[i - 1] > W:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
                                   dp[i - 1][j])
        return dp[n][W]

# Driver Code
profit = [60, 100, 120]
weight = [10, 20, 30]
W = 50
solution = Solution()
print(solution.knapSack(W, weight, profit))



