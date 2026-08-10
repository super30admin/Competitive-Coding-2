# https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

# Time complexity: O(NW) 
# Space complexity: O(W)
# Explanation: Cannot use greedy here, need to use DP instead. Can use bottom up apporach with tabulation. Create the tabulation table with the logic:
# For each item and capacity, there are two choices, and we need to choose the minimum: either skip the item, in which case the value stays `dp[j]`, or take it, in which case add the item’s value to the best value which could be gooten with the remaining capacity, `dp[j - w] + v`.
# Finally return the dp[W] which will contain the maximum value possible

class Solution:
    def knapsack(self, W: int, val: list[int], wt: list[int]) -> int:
        dp = [0] * (W + 1)
        for i in range(1, len(val) + 1):
            w, v = wt[i - 1], val[i - 1]
            for j in range(W, w - 1, -1):
                dp[j] = max(dp[j], dp[j - w] + v)
        return dp[W]
