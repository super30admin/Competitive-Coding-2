"""
Given N items where each item has some weight and profit associated with it and also given a bag with capacity W,
[i.e., the bag can hold at most W weight in it].
The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.
Note: The constraint here is we can either put an item completely into the bag or cannot put it at all
[It is not possible to put a part of an item into the bag].
Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3

# Time Complexity: O(n * w)
# Space Complexity: O(n * w)
"""

N = 3
W = 5
# profit = [1, 2, 3]
# weight = [4, 5, 1]

weight = [1, 2, 3]
profit = [60, 100, 120]


def knapsack_2d(w, weight, profit):
    # method 1:
    # Time Complexity: O(n * w)
    # Space Complexity: O(n * w)

    n = len(weight)
    dp = [[0] * (w + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        for j in range(1, w + 1):
            if weight[i - 1] <= j:
                print(dp[i - 1][j - weight[i - 1]])
                dp[i][j] = max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j])
            else:
                dp[i][j] = dp[i - 1][j]

    return dp[n][w]


print(knapsack_2d(W, weight, profit))
