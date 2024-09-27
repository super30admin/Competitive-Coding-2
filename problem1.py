##Time Complexity : O(mn)
##Space Complexity :O(mn)
def knapSack(value, weight, W):
    n=W
    m=len(value)
    dp = [[0 for i in range(n+1)] for j in range(m+1)]
    for i in range(1,m+1):
        for j in range(1,n+1):
            if j<weight[i-1]:
                dp[i][j]=dp[i-1][j]

            dp[i][j]=max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1])
    return dp[m][n]
value = [10, 20, 50]
weight = [1, 2, 3]
W = 6
print(knapSack(value, weight, W))