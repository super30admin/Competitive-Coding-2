

profit = [60, 100, 120]
weight = [10, 20, 30]
W = 50

import collections

def maximizeProfit(profit, weight, w):
    if len(profit) == 0 or w == 0:
        return 0
    
    dp = collections.defaultdict(int)

    return helper(profit, weight, w, 0, dp)

def helper(profit, weight, w, index, dp):
    if index >= len(profit) or w == 0:
        return 0
    
    if (index, w) in dp:
        return dp[(index, w)]
    
    profit1 = 0
    if weight[index] <= w:
        profit1 = profit[index] + helper(profit, weight, w - weight[index], index + 1, dp)
    
    profit2 = helper(profit, weight, w, index + 1, dp)
    
    dp[(index, w)] = max(profit1, profit2)
    return dp[(index, w)]

print(maximizeProfit(profit, weight, W))