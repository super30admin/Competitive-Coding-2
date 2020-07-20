# APPROACH 1: BRUTE FORCE RECURSIVE
# Time Complexity : O(2 ^ v), v: length of values array
# Space Complexity : O(v) 
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Its a recursive solution. Base case: scanned through all items or current weight exceeded the capacity
# 2.  Case 1: not choosing the item, no change to current weight or cost, move on to the next item
# 3. Case 2: Choosing the item -> Sub case1: if weight till now and the weight of the current item exceeds the capacity, then have to move on to the next item
#                             -> Sub case2: if weight till now and the weight of the current item is within capacity, then add the value and weight of the current item and move to next item
# 4. Consider the max of all the cases.


def knapsack(weight, value, capacity):
    return helper(weight, value, capacity, 0, 0, 0)

def helper(weight, value, capacity, ind, curr_cost, curr_weight):

    if curr_weight >= capacity or ind >= len(weight):
        return curr_cost

    # Not taking the item
    case_1 = helper(weight, value, capacity, ind + 1, curr_cost, curr_weight)

    # taking the item
    if curr_weight + weight[ind] <= capacity:
        case_2 = helper(weight, value, capacity, ind + 1, curr_cost + value[ind], curr_weight + weight[ind])
    else:
        case_2 = helper(weight, value, capacity, ind + 1, curr_cost, curr_weight)

    return max(case_1, case_2)




# APPROACH 2: DYNAMIC PROGRAMMING
# Time Complexity : O(cw), c: capacity and w: length of weight list
# Space Complexity : O(cw)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : Couldn't visualise the table
#
#
# Your code here along with comments explaining your approach
# 1. dp table of size (capacity * len(weights)). 1st row and 1st column is 0
# 2. Each cell value stores the max value found so far with the capacity (column) and weights (all rows till now)
# 3. Case1: don't choose the item, (not choosing current weight (row), then previous row value)
#    Case2: choose the item, current item's value + value of the remaining capacity (with the preceeding weights)
# 4. Final result is the last cell value

  def knapsack(self, weight, value, capacity):

        if not weight or not value or capacity <= 0:
            return 0

        dp = [[None for _ in range(capacity + 1)] for _ in range(len(weight) + 1)]

        for row in range(len(dp)):
            dp[row][0] = 0

        for column in range(1, len(dp[0])):
            dp[0][column] = 0

        for row in range(1, len(dp)):
            for column in range(1, len(dp[0])):

                if column < weight[row - 1]:
                    dp[row][column] = dp[row - 1][column]

                else:
                    dp[row][column] = max(dp[row - 1][column], value[row - 1] + dp[row - 1][column - weight[row - 1]])

        return dp[-1][-1]
