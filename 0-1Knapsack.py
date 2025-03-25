# Time Complexity: O(n*m) where n is the number of items and m is the capacity
# Space Complexity: O(n*m) where n is the number of items and m is the capacity

# Approach:
# Dynamic Programming approach
# 1. We will create a 2D array to store the maximum profit.
# 2. We will iterate through the array and calculate the maximum profit at each step.
# 3. If the current item weighs more than the capacity, we don't want to add it.
# 4. We will return the maximum profit at the end.

class Solution:
    def knapsack(self, weight, w, p):
        # 0/1 Knapsack DP approach
        rows, cols = len(w)+1, weight+1
        # create a 2D array to store the maximum profit
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        # iterate through the array and calculate the maximum profit at each step
        for i in range(1, rows):
            for j in range(1, cols):
                # if the current item weighs more than the capacity, we don't want to add it
                if j < w[i-1]:
                    dp[i][j] = dp[i-1][j]
                # We observe that the current item can be added to the knapsack if the weight of the current item is less than or equal to the capacity of the knapsack.
                # Thus, we calculate the maximum profit that can be obtained by either including the current item or excluding it.
                else:
                    dp[i][j] = max(dp[i-1][j], p[i-1] + dp[i-1][j-w[i-1]])
        # return the maximum profit
        return dp[rows-1][cols-1]


# Time Complexity: O(2^n) where n is the number of items
# Space Complexity: O(1)

# Approach:
# 1. We will have 2 choices at each step, either we choose an item or we don't choose an item.
# 2. We will follow both paths and get the maximum profit out of both.
# 3. If the current item weighs more than the capacity, we don't want to add it.
# 4. We will follow the above steps recursively and return the maximum profit.
class Solution:
    def knapsack(self, weight, w, p):
        return self.helper(w, p, weight, 0, 0)
    
    def helper(self, w, p, weight, profit, i):
        # base case
        if i == len(w) or weight <= 0:
            return profit
        
        # if the current item weighs more than the capacity, we don't want to add it
        if w[i] > weight:
            return self.helper(w, p, weight, profit, i+1)
        
        # there will be 2 decisions at each step
        # either we choose an item, or not choose an item
        # we want to follow both paths and get the maximum profit out of both
        return max(self.helper(w, p, weight, profit, i+1),
                   self.helper(w, p, weight-w[i], profit + p[i], i+1))