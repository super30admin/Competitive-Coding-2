# 0/1 Knapsack

# Recursive
# Time Complexity: O(2^n)
# Space Complexity: O(m+n), m is capacity, n is len(wt) -> Recursive Stack Space
def knapsack_rec(wt, val, cap):
    i = len(val)
    j = cap
    return helper(wt, val, i, j)

def helper(wt, val, i, j):
    # Base
    if i == 0 or j == 0:
        return 0
    steal = 0
    if j - wt[i-1] >= 0:
        steal = val[i-1] + helper(wt, val, i-1, j-wt[i-1])
    dont_steal = helper(wt, val, i-1,j)
    return max(steal, dont_steal)

# DP
# Time Complexity: O(m*n) - m is capacity, n is len(wt)
# Space Complexity: O(m*n) - m is capacity, n is len(wt)
def knapsack_dp(wt, val, cap):
    if not wt or not val:
        return 0
    dp = [[0 for _ in range(cap+1)] for _ in range(len(wt)+1)]
    for i in range(len(wt)+1):
        for j in range(cap+1):
            if i == 0 or j == 0:
                dp[i][j] = 0
            steal = 0
            if j - wt[i-1] >= 0:
                steal = val[i-1] + dp[i-1][j-wt[i-1]]
            dont_steal = dp[i-1][j]
            dp[i][j] = max(steal, dont_steal)
    return dp[-1][-1]
                


wt = [1,2,4]
val = [60,100,120]
cap = 5
print(knapsack_rec(wt, val, cap))
print(knapsack_dp(wt, val, cap))
