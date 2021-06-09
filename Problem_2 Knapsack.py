# // Time Complexity : O(n*C) Where C is the Capacity
# // Space Complexity : O(n*C)
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

def knapsack(w, p, n, C):
    if not w or n == 0: return 0
    dp = [[0] * (C+1) for _ in range(len(w)+1)]
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if j < w[i-1]:
                #copy results from prev row
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i-1]]+p[i-1])
    return dp[len(dp)-1][len(dp[0])-1]