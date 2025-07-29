# TimeComplexity:O(n^2)
# SpaceComplexity:O(n)
# Approach: if you are at weight W go backwards and try tofind max possible valid weight


class Solution:
    def knapsack(self, W, val, wt):
        n = len(val)
        dp = [0] * (W + 1)
        
        for i in range(n):  # iterate over items
            for w in range(W, wt[i] - 1, -1):  # go backwards!
                dp[w] = max(dp[w], dp[w - wt[i]] + val[i])
                
        return dp[W]
