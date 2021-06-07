"""
Approach:
Follows the pattern of coin change.
if knapsack capacity is less than available max size, pick value rom the row above
else, pick the max of what you can grab and the previous max
"""

def knapsack(weights, values, max_weight):
    dp = [[0 for _ in range(max_weight + 1)] for _ in range(len(values) + 1)]

    for i in range(1, len(values) + 1):
        for j in range(1, max_weight + 1):
            if j < weights[i-1]:
                dp[i][j] = dp[i - 1][j]

            else:
                dp[i][j] = max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]])
    return dp[-1][-1]

"""
TC: O(mn) m-> max weight/capacity of knapsack. n-> number of items available to pick
SC: O(mn)
"""
