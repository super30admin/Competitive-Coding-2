#Knapsack Problem
def knapsack(i,W,profit,weight):
    #base
    if i == 0:
        if weight[0] <= W:
            return profit[0]
        else:
            return 0

    
    if dp[i][W] != -1:
        return dp[i][W]
    #logic
    notTake = knapsack(i-1,W,profit,weight)
    take = 0

    if weight[i] <= W:
        take = profit[i] + knapsack(i-1, W-weight[i],profit,weight)

    dp[i][W] = max(take,notTake)
    return max(take,notTake)

profit = [10, 20, 30]
weight = [40, 50, 60]
W = 10
n = len(weight)
dp = [[-1 for _ in range(W+1)] for _ in range(n+1)]

print(knapsack(n-1, W, profit, weight))