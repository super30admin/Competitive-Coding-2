# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : no
# Any problem you faced while coding this : no

def knapSack(weight, profit, W, n):
    if n == 0 or W == 0:
        return 0
    return helper(profit, weight, W, 0 , 0)

def helper(profit, weight, capacity, i, totalProfit):
    # Base case: no more items to consider
    if i >= len(weight):
        return totalProfit

    # Case 0: Skip the current item
    case0 = helper(profit, weight, capacity, i + 1, totalProfit)

    # Case 1: Pick the current item (if its weight is within the remaining capacity)
    case1 = 0
    if weight[i] <= capacity:
        case1 = helper(profit, weight, capacity - weight[i], i + 1, totalProfit + profit[i])

    return max(case0, case1)


# Test the function
print(knapSack([10, 20, 30], [60, 100, 120], 50, 3))  