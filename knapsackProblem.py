# Time Complexity : O(n*m), where n is the length of value array and m is the capacity
# Space Complexity : O(n*m), where n is the length of value array and m is the capacity
# Did this code successfully run on Leetcode : N.A., running on PyCharm
# Any problem you faced while coding this : A little bit, had trouble with the recursive solution.

# Your code here along with comments explaining your approach
class Solution(object):
    # approach 1 Brute Force/Greedy using Recursion
    def knapsackGreedy(self, capacity, value, weights):
        if not weights or not value:
            return 0
        return self.helper(capacity, value, weights, len(value), 0, 0)

    def helper(self, remaining_capacity, profit, weights, n, i, max_profit):
        # Base Case
        if i >= n or remaining_capacity == 0:
            return max_profit
        # Logic
        if weights[i] > remaining_capacity:
            return self.helper(remaining_capacity, profit, weights, n, i + 1, max_profit)
        # choose
        choose = self.helper(remaining_capacity - weights[i], profit, weights, n, i + 1, max_profit + profit[i])
        # not choose
        not_choose = self.helper(remaining_capacity, profit, weights, n, i + 1, max_profit)

        return max(choose, not_choose)

    # approach 2 using DP
    #
    # for each value calculate the maximum value by either taking 0 case or by going
    # weight indexes back in array and adding the corresponding value for every capacity
    # until the given capacity, return calculation for last value at given capacity
    def knapsack(self, capacity, value, weights):
        n = len(value)
        dpArray = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, capacity + 1):
                if j < weights[i - 1]:
                    dpArray[i][j] = dpArray[i-1][j]
                else:
                    dpArray[i][j] = max(dpArray[i-1][j], dpArray[i-1][j - weights[i-1]] + value[i-1])
        return dpArray[-1][-1]


value = [60, 100, 120]
weights = [10, 20, 30]
W = 50
print(Solution().knapsack(W, value, weights))
