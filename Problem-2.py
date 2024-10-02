# T.C = O(m+n) S.C = m+n
def KnapSack(weight,profit,capacity):
    
    m = len(weight)
    n = capacity
    
    dp = [[0 for x in range(n+1)]for x in range(m+1)]

    for i in range(1,m+1):
        for j in range(1,n+1):
            if(j<weight[i-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j],profit[i-1]+dp[i-1][j-weight[i-1]])

    return dp[m][n]

profit = [60,100,120]
weight = [10,20,30]
capacity = 50
print(KnapSack(weight,profit,capacity))
