def knapsack_01(c, v, w):
    n = len(v)
    
    # Create a 2D DP array, where dp[i][j] represents the maximum value for the first i items with a capacity of j
    dp = [[0 for _ in range(c + 1)] for _ in range(n + 1)]
    print(dp)
    
    # Build the DP table
    for i in range(1, n + 1):
        for j in range(1, c + 1):
            # Take
            if w[i - 1] <= j:  # Check if the current item's weight can fit in the knapsack
                # Max of including the item or excluding the item
                dp[i][j] = max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j])
            else: # Skip
                dp[i][j] = dp[i - 1][j]
    
    return dp[n][c]  # The bottom-right cell contains the result

# Example usage:
print(knapsack_01(4, [1, 2, 3], [4, 5, 1]))  # Output: 3
print(knapsack_01(3, [1, 2, 3], [4, 5, 6]))  # Output: 0
print(knapsack_01(5, [10, 40, 30, 50], [5, 4, 6, 3]))  # Output: 50
print(knapsack_01(10, [20, 30, 10, 50], [1, 3, 4, 6]))  # Output: 100

# T: O(n * m), S: O(n * m)