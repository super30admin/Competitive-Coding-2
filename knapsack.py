def knapSack(W, wt, val, n):
    
    # Create a 2D DP table to store results of subproblems
    dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]
    
    # Build the table bottom-up
    for i in range(1, n + 1):
        for w in range(1, W + 1):
            if wt[i - 1] <= w:
                dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w])
            else:
                dp[i][w] = dp[i - 1][w]
    
    return dp[n][W]


# Driver Code
if __name__ == "__main__":
    profit = [60, 100, 120]
    weight = [10, 20, 30]
    W = 50
    n = len(profit)
    
    # Print the result
    print("Maximum value in knapsack: ", knapSack(W, weight, profit, n))
