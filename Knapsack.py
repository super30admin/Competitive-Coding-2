# Time Complexity : O(n*m)
# Space Complexity : O(n*m)

# Maintain a 2D DP array which computes maximum price we can accumulate for that capacity

def knapsack(weights, prices, capacity):

    n = len(weights)

    dp = [[0 for _ in range(capacity + 1)] for _ in range(n+1)]
    for i in range(1, n+1):
        for j in range(1, capacity + 1):
            cur_weight = weights[i-1]
            if j < cur_weight:
                dp[i][j] = dp[i-1][j]

            else:
                prev_val = dp[i-1][j-weights[i-1]] if j-weights[i-1] >= 0 else 0
                
                dp[i][j] = max(dp[i-1][j], prices[i-1] + prev_val)
    # print(dp)
    return dp[-1][-1]

capacity = 4; weights = [4, 5, 1]; prices = [1,2,3]

print(knapsack(weights, prices, capacity))