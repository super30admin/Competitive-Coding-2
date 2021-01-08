# Knapsack
# w = [2,3,5]
# p = [1,2,6]
# n = 3; C = 8

# TC = O(n*C)
# SC = O(n*C)
# First, tring brute force trying all the different combinations using recursion tree- we end up with exponential time complexity. Each iteration we chose element or not- changing parameters are index of array and remaining capacity. Build DP table to record repeated subproblems.

# DP approach
def knapsack(w, p, n, C):
    if not w or n == 0: return 0
    dp = [[0] * (C+1) for _ in range(len(w)+1)]
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if j < w[i-1]:
                # while next weight is available sto use - we can copy results from prev row
                dp[i][j] = dp[i-1][j]
            else:
                # when new weight is available we take the best of prev result and current profit added to prev most available state from where we add the current profit
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i-1]]+p[i-1])
    return dp[len(dp)-1][len(dp[0])-1]

# Driver code
val = [60, 100, 120] 
wt = [10, 20, 30] 
W = 50
n = len(val)
print(knapsack(wt, val, n, W)) 