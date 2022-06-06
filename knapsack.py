#Time complexity: O(weights)*O(capacity)
#Space complexity: O(weights)*O(capacity)
def knapsack(weights, values, capacity):
    dp=[[0 for i in range(capacity+1)] for i in range(len(weights)+1)]
    for i in range(len(dp[0])):
        dp[0][i]=0
    for i in range(len(dp)):
        dp[i][0]=0
    for weight in range(1,len(dp)):
        for cap in range(1,len(dp[0])):
            if cap<weight-1:
                dp[weight][cap]=dp[weight-1][cap]
            else:
                dp[weight][cap]=max(dp[weight-1][cap], values[weight-1]+dp[weight-1][cap-weights[weight-1]])
    return dp[len(weights)][capacity]
res=knapsack([1,2,3],[10,15,40],6)
print(res)
