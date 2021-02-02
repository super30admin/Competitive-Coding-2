# O(N * W) TIME AND O(N * W) SPACE WHERE N IS NO.OF ITEMS AND W IS MAX WEIGHT

def knapSack(values,weights,max_wt):
    dp = [[0 for j in range(max_wt+1)]for i in range(len(values)+1)]
    
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            dp[i][j] = max(dp[i-1][j], values[i-1] + dp[i-1][j- weights[i-1]])
    
    return dp[-1][-1]


print(knapSack([60,100,120],[10,20,30],50))