# Time Complexity =O(len(w)*t)
# Space Complexity =O(len(w)*t)
def knapsack(w,v,t):
    dp=[[0]*(t+1) for _ in range(len(w)+1)]
    for i in range(t+1):
        dp[0][i]=0
    for i in range(len(w)+1):
        dp[i][0]=0
    for i in range(1,len(w)+1):
        for j in range(1,t+1):
            if j<w[i-1]:
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]])
    return dp[len(w)][t]