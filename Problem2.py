# 0/1 Knapsack problem. Using DP approach and optimizing space
# TC: O(nxW)
# SC: O(W)


def knapSack(W, wt, val, n):

    dp = [0 for i in range(W+1)]

    for i in range(1, n+1):
      
        for w in range(W, 0, -1):
            if wt[i-1] <= w:

                dp[w] = max(dp[w], dp[w-wt[i-1]]+val[i-1])
                
    return dp[W]
