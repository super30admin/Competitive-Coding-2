"""
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the
knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum
value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an
item, either pick the complete item or don’t pick it (0-1 property).

https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
"""

def helper(weights, costs, target, index, maxProfit):
    # base
    if index >= len(weights):
        return maxProfit

    # logic
    if weights[index] > target:
        return helper(weights, costs, target, index + 1, maxProfit)

    choose = helper(weights, costs, target - weights[index], index + 1, maxProfit + costs[index])
    not_choose = helper(weights, costs, target, index + 1, maxProfit)
    return max(choose, not_choose)


def knapsack(weights, costs, target):
    if len(weights) == 0:
        return 0

    return helper(weights, costs, target, 0, 0)


print(knapsack([10,20,30], [60,100,120], 50))