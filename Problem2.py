#Approach1:
#Go item by item and either skip or pick it if it fits.
#If picked, add its profit and reduce the capacity.
#If not picked, move to the next item.
#Return the max of both choices to get the best profit.
#Time Complexity: O(2^n) where n is the number of items.
#Space Complexity: O(n) for the recursion stack.
class Solution:
    def knapsack(weights, profit, totalCapacity):
        return Solution.helper(weights, profit, 0, totalCapacity)
    def helper(weights, profit, i, capacity):
        if i >= len(weights):
            return 0
        case0 = Solution.helper(weights, profit, i + 1, capacity)
        case1 = 0
        if capacity - weights[i] >= 0:
            case1 = profit[i] + Solution.helper(weights, profit, i + 1, capacity - weights[i])
        return max(case0, case1)
    
#Approach2:
#Recursively decide for each item: to skip or to include it if capacity allows.
#If included, add its profit and reduce capacity, and store results to avoid repeats.
#This memoization avoids recalculating the same subproblems again and again.
#Time Complexity: O(m*n) where m is the number of items and n is the capacity.
#Space Complexity: O(m*n) for the memoization table.
class Solution:
    memo = []
    def knapsack(weights, profit, totalCapacity):
        m = len(weights)
        n = totalCapacity
        Solution.memo = [[0] * (n + 1) for _ in range(m)]
        return Solution.helper(weights, profit, 0, totalCapacity)
    def helper(weights, profit, i, capacity):
        if i >= len(weights):
            return 0
        if Solution.memo[i][capacity] != 0:
            return Solution.memo[i][capacity]
        case0 = Solution.helper(weights, profit, i + 1, capacity)
        case1 = 0
        if capacity - weights[i] >= 0:
            case1 = profit[i] + Solution.helper(weights, profit, i + 1, capacity - weights[i])
        Solution.memo[i][capacity] = max(case0, case1)
        return Solution.memo[i][capacity]
    
#Approach3:
#Uusing a 2D DP table to store the best profit we can make for each capacity and number of items.
#For each item, check if we can include it or not, and take the better profit.
#In the end, the answer is in the last cell representing all items and full capacity.
#Time Complexity: O(m*n) where m is the number of items and n is the capacity.
#Space Complexity: O(m*n) for the DP table.
class Solution:
    def knapsack(weights, profit, totalCapacity):
        n = totalCapacity
        m = len(weights)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if weights[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weights[i - 1]])       
        return dp[m][n]
    
#Approach4:
#use a 1D array to keep track of max profit for every capacity.
#For each item, go backward to avoid overwriting previous states.
#In the end, the last cell gives the best profit for full capacity.
class Solution:
    def knapsack(weights, profit, totalCapacity):
        n = totalCapacity
        m = len(weights)
        dp = [0] * (n + 1)
        for i in range(m):
            for j in range(n, weights[i] - 1, -1):
                dp[j] = max(dp[j], profit[i] + dp[j - weights[i]])
        return dp[n]
