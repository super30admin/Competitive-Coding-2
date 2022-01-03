# Time Complexity: O(N*W)
# Space Complexity: O(N*W)
import sys

def Knapsack(weights, values, capacity):
    #DP- BottomUp
    dp = [[sys.maxint for i in range(capacity+1)]]*(len(weights)+1)
    dp[0][0] = 0
    for i in range(1, len(dp)):
        for j in range(len(dp[0])):
            if (j<weights[i-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = min(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1])
    result = dp[-1][-1]
    return result

values = [60, 100, 120]
weights = [10, 20, 30]
capacity = 50

print(Knapsack(weights, values, capacity))