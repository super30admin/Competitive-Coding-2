# Knapsack problem 

# Recursive approach - O(2 ^ N) Time complexity


def knapsack(capacity, profit, weights, n):
    
    return helper(capacity, profit, weights, len(profit), 0, 0)
    
def helper(remaining_capacity, profit, weights, n, i, max_profit):

    #base case
    
    if i >= n or remaining_capacity == 0:
        return max_profit

    #logic

    if weights[i] > remaining_capacity:
        return helper(remaining_capacity, profit, weights, n, i+1, max_profit)

    # choose

    chosen = helper(remaining_capacity - weights[i], profit, weights, n, i+1, max_profit + profit[i])


    # dont choose

    not_chosen = helper(remaining_capacity, profit, weights, n, i+1, max_profit)

    return max(chosen, not_chosen)

# DP Solution
# Time - O(M * N)
# Space - O(M * N)
def knapsack(capacity, val, weights, vals):
    
    rows = len(vals) + 1
    cols = capacity + 1
    
    dp = [[0 for j in range(cols)] for i in range(rows)]
    
    for i in range(1, rows):
        for w in range(1, cols):
            
            if w < weights[i-1]:
                dp[i][w] = dp[i-1][w]
                
            else:
                dp[i][w]  = max(dp[i-1][w], dp[i-1][w - weights[i-1]] + val[i-1])
            
            
    return dp[rows -1][capacity]