"""
Problem: Knapsack problem
Solution: Dynamic Programming - bottom up approach
Time Complexity: O(N*W), n is the number of elements in weights, w is the capacity
Space Complexity: O(N*W), use of 2D array
"""


class Solution:
    def knapsack(self, capacity, profit, weights, n):
        dp = [[0 for x in range(capacity + 1)] for x in range(n + 1)]

        # Build dp table with bottom up approach
        for i in range(n + 1):
            for cap in range(capacity + 1):
                if i == 0 or cap == 0:
                    dp[i][cap] = 0
                elif weights[i - 1] <= cap:
                    dp[i][cap] = max(profit[i-1] + dp[i-1][cap - weights[i-1]], dp[i-1][cap])
                else:
                    dp[i][cap] = dp[i-1][cap]
        return dp[n][capacity]


obj = Solution()
capacity = 50
profit = [60, 100, 120]
weights = [10, 20, 30]
n = 3
print(obj.knapsack(capacity, profit, weights, n))

capacity = 8
profit = [1, 2, 6]
weights = [2, 3, 5]
n = 3
print(obj.knapsack(capacity, profit, weights, n))