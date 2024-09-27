# Knapsack Problem

# Time Complexity :  O(n) where n is the size of the dp matrix 

# Space Complexity : O(n) where n is the size of the dp matrix 

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Create a matrix with weights as rows and capacity increments as columns. If the weight is
# smaller than the capacity, use the previous weight. Else use the max of the previous cell and sum
# of the value at previous weight and the matrix value of weight at that point. Return the last cell.

# Your code here along with comments explaining your approach

def solution(weight, values, capacity):

    dp = [[0 for x in range(capacity+1)] for y in range(len(weight)+1)]

    for i in range(1, len(weight)+1):
        for j in range(1, capacity+1):
            if (j < weight[i-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j],values[i-1]+ dp[i-1][j-weight[i-1]])

    return dp[len(weight)][capacity]


weight = [10, 20, 30, 20]
values = [60, 100, 120, 200]
capacity = 50

print(solution(weight, values, capacity))
