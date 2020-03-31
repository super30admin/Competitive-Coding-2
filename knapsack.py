# Space = O(n^2)
# Time complexity = O(n^2)

def knapsack(w,v,cap):
    dp = [[0 for _ in range(cap+1)] for _ in range(len(w)+1)]
    for i in range(1,len(w)+1):
        for j in range(cap+1):
            if w[i-1] > j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1])
    return dp[-1][-1]


print(knapsack([1, 3, 4, 5],[10, 40, 50, 70],7))



