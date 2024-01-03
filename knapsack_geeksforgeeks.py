# Knapsack problem
# Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
# In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
# respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum
# of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick
# it (0-1 property).
#time complexity: O(n*W)
#space complexity: O(n*W)

class Solution:

    # Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self, W, wt, val, n):
    # Initialize a 2D table to store the results of subproblems
        dp = [[0] * (W + 1) for _ in range(n + 1)]

    # Fill the table in bottom-up manner
        for i in range(n + 1):
            for w in range(W + 1):
                if i == 0 or w == 0:
                    dp[i][w] = 0
                elif wt[i - 1] <= w:
                    dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w])
                else:
                    dp[i][w] = dp[i - 1][w]

    # The result is stored in the bottom-right cell of the table
        return dp[n][W]

