# Knapsack problem 
weight = [1, 2, 3]
values = [6,10,12]
capacity = 5

# Time complexity O(n^2)
# Space complexity O(n)
def knapsack(weight, values, capacity):
    if not weight or not values: # edge cases 
        return -1 
    if capacity <= 0:
        return 0
    col = capacity + 1 
    row = len(weight) + 1

    # Using 1 D array
    dp = [0] * (capacity + 1)

    for i in range(len(weight)):
        # travers in reverse 
        for j in range(capacity, weight[i] - 1, -1):
            dp[j] = max(dp[j], dp[j - weight[i]] + values[i])

    return dp[capacity] 

print(knapsack(weight, values, capacity))