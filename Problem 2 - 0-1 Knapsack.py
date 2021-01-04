def Knapsack(weights, values, target):
    #Time Complexity: O(target * weights.length)
    #Space Complexity: O(target * weights.length)
    
    dp = [[0 for i in range(target + 1)] for j in range(len(weights) + 1)]

    for wt in range(1, len(dp)):
        for cap in range(len(dp[0])):
            if cap < weights[wt - 1]:
                dp[wt][cap] = dp[wt - 1][cap]

            else:
                dp[wt][cap] = max(dp[wt - 1][cap], values[wt - 1] + dp[wt - 1][cap - weights[wt - 1]])

    return dp[-1][-1]

weights = [10, 20, 30]
values = [60, 100, 120]
target = 50

sol = Knapsack(weights, values, target)
print(sol)