def max_profit(profit, weights, capacity):
    m = len(weights) + 1
    n = capacity + 1
    dp = [[0] * (n) for _ in range(m)]

    for i in range(1,m):
        for j in range(1,n):
            if j < weights[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], profit[i-1] + dp[i-1][j-weights[i-1]])
    return dp[m-1][n-1]




profit = [60, 100, 120]
weights = [10, 20, 30]
capacity = 50
print(max_profit(profit,weights,capacity))