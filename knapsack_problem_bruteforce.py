"""
Problem: Knapsack problem
Solution: Bruteforce approach, Recursion stack
Time Complexity: O(2^n)
Space Complexity: O(n)
"""


class Solution:
    def knapsack(self, capacity, profit, weights, n):
        return self.__helper(capacity, profit, weights, n, 0, 0)

    def __helper(self, remaining_capacity, profit, weights, n, i , max_profit):

        # base case
        if i >= n or remaining_capacity == 0:
            return max_profit

        # logic
        if weights[i] > remaining_capacity:
            return self.__helper(remaining_capacity, profit, weights, n, i+1 , max_profit)

        # choose
        choose = self.__helper(remaining_capacity - weights[i], profit, weights, n, i + 1, max_profit+profit[i])

        # not choose
        not_choose = self.__helper(remaining_capacity, profit, weights, n, i + 1, max_profit)

        return max(choose, not_choose)


obj = Solution()
capacity = 50
profit = [60, 100, 120]
weights = [10, 20, 30]
n = 3
print(obj.knapsack(capacity, profit, weights, n))

capacity = 8
profit = [1, 2, 6]
weights = [2,3,5]
n = 3
print(obj.knapsack(capacity, profit, weights, n))