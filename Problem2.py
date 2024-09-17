# Knapsack problem: Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack

""" BRUTE FORCE SOLUTION (USING RECURSION: 
def knapsack(capacity, profit, weights, n):
    
    def helper(capacity_left, profit, weights, n, i, max_profit):
        
        # Base Case
        if i >= n or capacity_left == 0:
            return max_profit
        
        # Logic
        if weights[i] > capacity_left:
            return helper(capacity_left, profit, weights, n, i+1, max_profit)
        
        # Choice and no choice
        choose = helper(capacity_left - weights[i], 
                        profit, weights, n, i+1, max_profit+profit[i])
        not_choose = helper(capacity_left, 
                            profit, weights, n, i+1, max_profit)
        return max(choose, not_choose)
    
    return helper(capacity, profit, weights, n, 0, 0)
"""

# DP Solution (Use a DP array)

def knapsack(capacity, profit, weights, n):
    
    h, wi = n + 1, capacity + 1
    dp = [[0 for __ in range(wi)] for __ in range(h)]
    
    for i in range(h):
        for j in range(wi):
            if i == 0 or j == 0:
                dp[i][j] = 0
            elif j < weights[i-1]:
                dp[i][j] = dp[i-1][j]
            else: 
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i-1]]+profit[i-1])

    return dp[n][capacity]
