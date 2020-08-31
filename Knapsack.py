
def checkProfit(weights, values, c):
    if c == 0 or len(weights) == 0 or len(values) == 0:
        return 0
    
    n = len(values)
    dp = [[0 for i in range(c + 1)] for j in range(n)]

    for i in range(0, n):
        dp[i][0] = 0
    
    for j in range(1, c + 1):
        if weights[0] <= c:
            dp[0][j] = values[0]
    
    
    for i in range(1, n):
        for j in range(1, c + 1):
            cc, dc = 0, 0
            if weights[i] <= j:
                cc = values[i] + dp[i-1][j-weights[i]]
            dc = dp[i-1][j]

            dp[i][j] = max(cc, dc)
    
    return dp[n-1][c] 



print checkProfit( [10,20,30], [2,1,10], 40)