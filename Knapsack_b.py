def knapsack(max_weight, weights, values):
    """
    Dynamic programming solution for the knapsack problem.
     max_weight: Maximum weight capacity of the knapsack.
     weights: List of weights of the items.
     values: List of values corresponding to the items.
     return: Maximum value that can be achieved.

    Time Complexity: O(nW)  n --> number of items; W --> maximum weight capacity 
    Space Complexity: O(nW)
    """
    n = len(weights)  # Number of items

    if n == 0 or max_weight == 0:  # Edge case: empty weights or zero maximum weight
        return 0

    # Create a 2D list to store the intermediate results
    dp = [[0 for _ in range(max_weight + 1)] for _ in range(n + 1)]

    for i in range(1, n + 1):  # Iterate over each item
        # Iterate over the weight capacity from 1 to max_weight
        for w in range(1, max_weight + 1):
            # If the weight of the current item is greater than the current weight capacity
            if weights[i - 1] > w:
                # Take the value from the previous row for the same weight capacity
                dp[i][w] = dp[i - 1][w]
            else:
                # Consider two choices: including or excluding the current item
                dp[i][w] = max(dp[i - 1][w], values[i - 1] +
                               dp[i - 1][w - weights[i - 1]])

    return dp[n][max_weight]  # Return the maximum value achieved


# Edge case: Empty weights and values lists
weights_empty = []
values_empty = []
max_weight_empty = 5
print(knapsack(max_weight_empty, weights_empty, values_empty))  # Output: 0

# Edge case: Zero maximum weight capacity
weights_zero_weight = [2, 3, 4]
values_zero_weight = [10, 20, 30]
max_weight_zero_weight = 0
print(knapsack(max_weight_zero_weight, weights_zero_weight,
      values_zero_weight))  # Output: 0

# Edge case: Zero items
weights_zero_items = []
values_zero_items = []
max_weight_zero_items = 5
print(knapsack(max_weight_zero_items, weights_zero_items,
      values_zero_items))  # Output: 0

# Regular case: Non-empty weights and values lists, positive maximum weight
weights = [1, 3, 4, 5]
values = [15, 50, 60, 90]
max_weight = 7
print(knapsack(max_weight, weights, values))
