# Time complexity is O(n * c) where n is the length of the weights list and c is the max capacity.
# Space complexity is O(n * c) where n is the length of the weights list and c is the max capacity.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def knapsack(weights, values, capacity):
    # Dp array with weights as rows and capacities as columns.
    dp =[[None for _ in range(capacity + 1)] for _ in range(len(weights) + 1)]
    for col in range(capacity + 1):
        dp[0][col] = 0    # At the 1st row, weight is 0. Max cap never reached.
    for i in range(1, len(dp)):         # Weights
        for j in range(len(dp[0])):     # Capacities
            curr_wt = weights[i - 1]
            if curr_wt > j:     # If the current weight is more than the capacity,
                dp[i][j] = dp[i - 1][j]     # copy from above row.
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - curr_wt] + values[i - 1]) # Maximum from not choosing weight and after choosing weight.
            
    return dp[len(dp) - 1][len(dp[0]) - 1]  # Last element is the max value.


weights = [10, 20, 40] 
values = [20, 40, 80]
capacity = 55
print(knapsack(weights, values, capacity)) 