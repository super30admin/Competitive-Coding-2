# TC : O(m × n)
#     Where m is the number of items and n is the knapsack capacity
#     Need to fill a table of size (m+1) × (n+1), with each cell taking constant time

# SC : O(m × n)
#     Use a 2D array of size (m+1) × (n+1) to store intermediate results

# Approach:
    # Create a 2D table dp[m+1][n+1] where m is the number of items and n is the capacity.
    # Each cell dp[i][j] represents the maximum profit that can be achieved with the first i items and capacity j.
    # For each item and capacity, we consider two possibilities:
        # Exclude the item (use value from previous row)
        # Include the item (add its profit to the profit from remaining capacity)
    # Choose the option that gives the maximum profit.
    # The final answer is stored in dp[m][n].

profit = [60, 100, 120]
weight = [10, 20, 30]
capacity = 50

m = len(weight)  # Number of items
n = capacity     # Capacity of knapsack

# Create a 2D array for dynamic programming
# dp[i][j] represents the maximum profit with first i items and capacity j
dp = [[0 for j in range(n+1)] for i in range(m+1)]

# Fill the dp table using bottom-up approach
for i in range(1, m+1):  # Iterate through all items
    for j in range(1, n+1):  # Iterate through all possible capacities
        if j < weight[i-1]:  # If current item doesn't fit in the knapsack
            # Skip the current item and use the solution without it
            dp[i][j] = dp[i-1][j]  # no choose case - take value from previous row
        else:
            # Take maximum of two cases:
                # 1. Item i excluded (value from previous row)
                # 2. Item i included (value = profit of current item + value from remaining capacity)
            dp[i][j] = max(dp[i-1][j], profit[i-1] + dp[i-1][j-weight[i-1]])

# Final cell contains the maximum profit achievable
print(dp[m][n])  # Print the maximum profit for the given knapsack capacity