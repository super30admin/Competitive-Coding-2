weights = [2, 3, 4, 5]
values = [1, 2, 3, 4]
capacity = 10


def helper(weights, values, capacity, maxCurrentWeight, idx):
    #     base
    if capacity == 0:
        return maxCurrentWeight
    if idx >= len(values) or capacity < 0:
        return -1

    choose = helper(weights, values, capacity - weights[idx], maxCurrentWeight + values[idx], idx + 1)
    noChoose = helper(weights, values, capacity, maxCurrentWeight, idx + 1)

    return max(choose, noChoose)


print(helper(weights, values, capacity, 0, 0))

# // Time Complexity : O(N)
 # // Space Complexity : O(N) since its a auxilary array
 # // Did this code successfully run on Leetcode : Yes
def maxWeight(weights, values, vapacity):
    if not weights:
        return 0
    dp = [[0] * (capacity + 1) for i in range(len(weights) + 1)]

    for i in range(1, len(weights) + 1):
        for j in range(1, capacity + 1):
            if j < weights[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1])
    return dp[-1][-1]

