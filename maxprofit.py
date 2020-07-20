def maxprofit(weights,profits,capacity):
    dp = [[0 for i in range(capacity + 1)] for j in range(len(weights) + 1)]
    sum = 0

    for i in range(1,len(weights) + 1):
        sum += weights[i-1]
        for j in range(1, capacity + 1):

            if sum < j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j - weights[i-1]] + profits[i-1]
    return dp[len(weights)][capacity]
print(maxprofit([3,2,6],[1,2,5],8))

