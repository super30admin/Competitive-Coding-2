# def helper( profit, weight, capacity, i, totalProfit):
    # # base case
    # if i >= len(weight): return totalProfit
    # #logic
    # case0 = helper(profit, weight, capacity, i + 1, totalProfit)

    # case1 = 0
    # if weight[i] <= capacity:
    #     case1 = helper(profit, weight, capacity - weight[i], i + 1, totalProfit + profit[i])

    # return max(case0, case1)


# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

def knapsack( profit, weight, capacity):
    m = len(weight)
    n = capacity

    dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if j < weight[i - 1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], profit[i - 1] + dp[i-1][j-weight[i - 1]])


    return dp[m][n]