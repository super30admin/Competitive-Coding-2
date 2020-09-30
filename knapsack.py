"""
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
"""
def knapsack(W, weights, values, n):

    dp = [0 * len(W + 1)] * len(n + 1)]

    for i in range(n + 1):
        for w in range(W + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0
            elif weights[i-1] <= w:
                dp[i][w] = max(val[i-1] + dp[i-1][w - weights[i-1]],
                dp[i-1][w])
            else:
                dp[i][w] = dp[i-1][w]

    return dp[n][W]

"""
"""
