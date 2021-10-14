"""
Time Complexity: O(n*capacity)
Space Complexity: O(n*capacity)
"""

def knapsack(capacity, profit, weights):
    dp = [[0 for _ in range(capacity + 1)] for _ in range(len(weights) + 1)]

    for i in range(0, len(weights) + 1):
        for w in range(0, capacity + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0
            elif w < weights[i - 1]:
                dp[i][w] = dp[i - 1][w]
            else:
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + profit[i - 1])
    return dp[len(weights)][capacity]


print(knapsack(50,  [60,100,120], [10,20,30]))