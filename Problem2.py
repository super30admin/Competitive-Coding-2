#Knapsack Problem
#Val=[6,10,12]
#wt=[1,2,3]
#targetWt=5

def knpsack(W, wt, val, n):
    dp = [[0 for x in range(W + 1)] for x in range(n + 1)]
    for i in range(n + 1):
        for j in range(W + 1):
            if wt[i-1] <= j:
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1])
            else:
                dp[i][j] = dp[i-1][j]
 
    return dp[n][W]

print(knpsack(50,[10,20,30],[60,100,120],3))

#TC: O(n*W)
#SC: O(n*W)