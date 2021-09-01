
#time complexity: O(N*M)
#space complexity: O(N*M)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

def memo(w,v,W):
    n = len(w)
    memo = [[-1 for i in range(0, W+1)] for j in range(0, len(w)+1)]
    return helper(w,v,W,n, memo)

def helper(w,v,W,n, memo):
    if n == 0 or W == 0:
        memo[n][W] = 0
    if memo[n][W] != -1:
        return memo[n][W]
    if w[n-1] <= W:
        memo[n][W] = max(v[n-1] + helper(w,v,W- w[n-1],n-1,memo), helper(w,v, W, n-1, memo))
    else:
        memo[n][W] = helper(w,v,W,n-1, memo)

    return memo[n][W]


def dp(w,v,W):
    n = len(w)
    dp = [[0 for x in range(W + 1)] for x in range(n + 1)]
    for i in range(0,n+1):
        dp[i][0] = 0
        for j in range(0, W+1):
            dp[0][j] = 0
            if w[i-1] <= j:
                dp[i][j] = max(v[i-1] + dp[i-1][j-w[i-1]], dp[i-1][j])
            else:
                dp[i][j] = dp[i-1][j]

    return dp[n][W]



w = [1,2,3]
v = [6,10, 12]
W = 5
print(dp(w,v,W))
print(memo(w,v,W))
