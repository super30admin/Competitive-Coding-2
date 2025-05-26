
# Approach 1
# def knapsack(value, weight, W):
#     m = len(weight)
#     dp = [[0 for j in range(W+1)] for i in range(m+1)]

#     for i in range(m+1):
#         for j in range(W+1):
#             if i == 0 or j == 0:
#                 dp[i][j] = 0
#             elif j < weight[i-1]:
#                 dp[i][j] = dp[i-1][j]
#             else:
#                 dp[i][j] = max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]])
#     return dp[m][W] 

# Approach 2

def knapsack(value, weight, W):
    m = len(weight)
    # Initializing dp list
    dp = [0] * (W + 1)

    # Taking first i elements
    for i in range(1, len(wt) + 1):
        
        # Starting from back, so that we also have data of
        # previous computation of i-1 items
        for j in range(W, wt[i - 1] - 1, -1):
            dp[j] = max(dp[j], dp[j - wt[i - 1]] + val[i - 1])
    
    return dp[W]

val = [1,2,3]
wt = [4,5,1]
W = 4
print(knapsack(val, wt, W))