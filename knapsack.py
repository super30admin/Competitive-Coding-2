# Time Complexity: O(m*n)
# Space complexity: O(m*n)
def knapsack(weights,profits,capacity):
    if (weights is None or len(weights)==0):
        return 0
    dp = [[0 for i in range(capacity+1)] for i in range(len(weights)+1)]
    print(dp)
    for i in range(len(dp)):
        for j in range(len(dp[0])):
            if (i == 0 or j ==0):
                dp[i][j] = 0
            elif (weights[i-1] > j):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], profits[i-1]+ dp[i-1][j-weights[i-1]])
    return dp[len(dp)-1][len(dp[0])-1]
weights = [1,2,3]
profits = [60,100,120]
capacity = 5
profit = knapsack(weights,profits,capacity)
print(profit)