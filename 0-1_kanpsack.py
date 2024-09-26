# Time Complexity: O( no of value elements * weight)
# Space Complexity: O( no of value elements * weight)
def knapsack(weight, weight_array, val_array):
    # Initialize the dp matrix with 0 with adding one dummy 0 layer
    dp = [[0 for i in range(weight + 1)] for j in range(len(val_array) + 1)]
    # Iterate over matrix and until the current value array is
    # equal to current weight value copy value from previous row
    # Or else take maximum of previous row value and addition of value of current value element and
    for i in range(len(val_array) + 1):
        for j in range(weight + 1):
            if i == 0 or j == 0:
                dp[i][j] = 0
            elif weight_array[i - 1] <= j:
                dp[i][j] = max(val_array[i - 1] + dp[i - 1][j - weight_array[i - 1]], dp[i - 1][j])
            else:
                dp[i][j] = dp[i - 1][j]

    return dp[len(val_array)][weight]


val = [10, 15, 40]
wt = [1, 2, 3]
W = 6
print(knapsack(W, wt, val))