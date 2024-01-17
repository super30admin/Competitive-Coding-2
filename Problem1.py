# Time Complexity: O(n*w)
# Space Complexity: O(w)
class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
        dp = [[0 for x in range(W + 1)] for x in range(n + 1)]

        for i in range(n + 1):
            for j in range(W+1):
                item_cost = wt[i-1]
                item_val = val[i-1]
                current_cap = j
                if i == 0 or j == 0:
                    dp[i][j] =  0
                elif current_cap < item_cost:
                    dp[i][j] = dp[i-1][j]
                else:
                    choose = item_val + dp[i-1][current_cap - item_cost]
                    not_choose = dp[i-1][current_cap]
                    dp[i][j] = max(choose, not_choose)
        return dp[-1][-1]
