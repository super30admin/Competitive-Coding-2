''' Time Complexity : O(m * n) 
    Space Complexity : O(m * n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''

def helper(weights, values, W):
    n = len(weights)
    dp = [[0] * (W + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for w in range(W + 1):
            if weights[i - 1] <= w:
                dp[i][w] = max( dp[i - 1][w],
                    values[i - 1] + dp[i - 1][w - weights[i - 1]])
            else:
                dp[i][w] = dp[i - 1][w]
    return dp[n][W]

    
values = [60, 100, 120]
weights= [10, 20, 30]
result = helper(weights,values,50)
print("Result = ", result)