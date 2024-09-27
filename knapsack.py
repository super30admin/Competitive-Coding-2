def knapsack(weights, values, cap):
    
    dp = [[0]*(cap+1) for i in range(len(weights)+1)]
    
    weights.insert(0,0)
    values.insert(0,0)
    
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if j >= weights[i]:
                dp[i][j] = max(dp[i-1][j], values[i] + dp[i-1][j - weights[i]])
            else:
                dp[i][j] = dp[i-1][j]
    
    return dp[-1][cap]