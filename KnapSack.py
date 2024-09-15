"""
Time Complexity : O(n*w) where n is the number of weight and w is the capacity
Space Complexity : O(n*w) where n is the number of weight and w is the capacity
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
def knapSack(wt, val, W, n):
    dp = [[0 for x in range(W + 1)] for x in range(n + 1)]
    for i in range(n + 1):
        for w in range(W + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0
            elif wt[i - 1] <= w:
                dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i -1][w])
            else:
                dp[i][w] = dp[i - 1][w]
    return dp[n][W]

# Driver code
val = [6, 10, 12]
wt = [1, 2, 3]
W = 5
n = len(val)
print(knapSack(wt, val, W, n))