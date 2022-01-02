# Time Complexity: O(len of weghts*W)
# Space Complexity : O(len of weghts*W)
def knapsack(vals, weights, W):
    dp = [[0 for x in range(W+1)] for y in range(len(weights)+1)]
    for i in range(1, W+1):
        dp[0][i] = 0
    for i in range(len(weights)+1):
        dp[i][0] = 0
    for i in range(1, len(weights)+1):
        for j in range(1, W+1):
            if weights[i-1] <= j:
                dp[i][j] = max(dp[i-1][j], vals[i-1]+dp[i-1][j-weights[i-1]])
            else:
                dp[i][j] = dp[i-1][j]
            
    return dp[len(weights)][W]
        
        
    
