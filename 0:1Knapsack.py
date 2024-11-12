# Approach:
# We use dynamic programming to solve the 0/1 Knapsack problem by maintaining a 1D array `dp`.
# For each item, we update the dp array from the end to the start, ensuring previous item values are considered.
# This ensures that we find the maximum profit for a knapsack of capacity `W`.

# Time Complexity: O(n * W), where n is the number of items and W is the knapsack capacity.
# Space Complexity: O(W), as we use a 1D array to store the results for each capacity up to W.
# Any problem you faced while coding this: No

def knapSack(W, wt, val, n):
    # Initialize the dp array to store max profit for each capacity
    dp = [0 for _ in range(W + 1)]

    # Loop over each item
    for i in range(1, n + 1):
        # Iterate from back of the dp array to the front
        for w in range(W, 0, -1):
            # Check if item can be included in the current weight capacity
            if wt[i - 1] <= w:
                # Update dp[w] to the max of including or excluding the item
                dp[w] = max(dp[w], dp[w - wt[i - 1]] + val[i - 1])

    # Return the max profit for the knapsack capacity W
    return dp[W]

# Driver code
if __name__ == '__main__':
    profit = [60, 100, 120]
    weight = [10, 20, 30]
    W = 50
    n = len(profit)
    print(knapSack(W, weight, profit, n))
