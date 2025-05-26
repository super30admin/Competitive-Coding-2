#Knapsack Problem
##Greedy didn't work and there are overlapping sub problems so went for DP(Tabulation method)
#Time complexity: O(M * N)
#Space Complexity: O(M * N)

def knapsack(profit, weight, capacity):
    m = len(weight)
    n = capacity

    # Initialize a 2D dp table with all 0s
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Build the dp table
    for i in range(1, m + 1): # i are weights
        for j in range(1, n + 1): # j is capacity 
            if j < weight[i - 1]:
                dp[i][j] = dp[i - 1][j]  # No choose case, when capacity is less than weights
            else:
                dp[i][j] = max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]])

    return dp[m][n]


profit = [60, 100, 120]
weight = [10, 20, 30]
capacity = 50

print(knapsack(profit, weight, capacity))
