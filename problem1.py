#Recursive Approach
def knapsack(val, wt, remaining_capacity, max_profit, index):
    # Base
    if index >= len(val) or remaining_capacity == 0:
        return max_profit
    # logic
    if wt[index] > remaining_capacity:
        return knapsack(val, wt, remaining_capacity, max_profit, index + 1)
    # choose
    choose = knapsack(val, wt, remaining_capacity-wt[index], max_profit + val[index], index + 1)
    #notchoose
    not_choose = knapsack(val, wt, remaining_capacity, max_profit, index + 1)
    return max(choose, not_choose)

val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
result = knapsack(val, wt, W, 0, 0)
print(result)


# Dynamic Programming
def knapsack(weights, value, capacity):
    dp=[[0 for _ in range(capacity+1)]for _ in range(len(value))]
    for i in range(len(value)):
        for j in range(capacity+1):
            if weights[i] > j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], value[i] + dp[i-1][j - weights[i]])
    return dp[-1][-1]

capacity=50
value=[60, 100, 120]
weights=[10, 20, 30]
val = knapsack(weights, value, capacity)
print(val)

