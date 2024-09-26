# Time Complexity: O(nm) where n is the number of weights and m is the size of the bag
# Space Complexity: O(nm) where n is the number of weights and m is the size of the bag

def knapsack(weights, values, size):
    dp = [[0 for i in range(size+1)] for j in range(len(weights) + 1)]
    for i in range(1, len(weights) + 1):
        for j in range(1, size + 1):
            if weights[i - 1] > j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j],(values[i-1] + dp[i-1][j - weights[i - 1]]))
    return dp[len(dp) - 1][size]


weights = [10, 20, 30]
values = [60, 100, 120]
m = 50

print(knapsack(weights, values, m))
