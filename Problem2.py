# TC==>O(n.t)
# SC===>O(n..t)
def knapsack(v, w, t):
    dp = [[0 for x in range(t + 1)] for y in range(len(v) + 1)]
    for i in range(1, len(v) + 1):
        for j in range(t + 1):
            if w[i - 1] > j:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1])
    return dp[len(v)][t]