# time complexity: O(N*W)
# space complexity: O(N*W)
# Approach: create dp array.
# if the weight(wt) is greater than the weight of column, the above row value will be copied.
# else, we take maximum of case-1 and case 2 in recursion
# case -1 in recursion-dont update wi, copy the above row
# case 2- update value with adding the remaining weight from previous row





def knapSack(W, wt, val, n):
    dp = [[0 for j in range(W + 1)] for i in range(n + 1)]
    for i in range(n + 1):
        for w in range(W + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0
            elif wt[i-1] <= w:
                dp[i][w] = max(val[i-1]
                          + dp[i-1][w-wt[i-1]], 
                              dp[i-1][w])
            else:
                dp[i][w] = dp[i-1][w]
 
    return dp[n][W]
 
 
# Driver code
val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
n = len(val)
print(knapSack(W, wt, val, n))
 