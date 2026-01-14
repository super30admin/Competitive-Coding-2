"""
time - o(n)
space - o(n)
we create a 2d array where inner array size = capacity and number of arrays is equal to the number of weights
we iterate each array which represents a weight in the weights array and each inner array cell is the current capacity of the sack
if the current capacity is lesser than the weight we take the previous weight's value at the same capacity, if not we take max between
previous weight's value at that capacity and capacity - weight's value plus current capacity's value
(what value we'll currently have if we choose the weight along with the previous choice)
"""


def knapsack(weights, values, capacity):
    n = len(weights)
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    for i in range(1, n + 1):
        for w in range(capacity + 1):
            if weights[i - 1] <= w:
                # Include or exclude current item
                dp[i][w] = max(
                    dp[i - 1][w],  # don't choose
                    dp[i - 1][w - weights[i - 1]] + values[i - 1],  # choose
                )
            else:
                # Cannot include current item
                dp[i][w] = dp[i - 1][w]

    return dp[n][capacity]
