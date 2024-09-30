"""
Brute force approach is to use the recursive tree. Time complexity is 2^m+n, where m is the number of
weights and n is capacity. And space complexity is also 2^m+n.
DP approach: Store the repeated sub problems into a 2D matrix, where rows are weights and columns are
capacities.
This reduces the time and space complexity to m*n and m*n
Todo: optimize space for 1 D array
"""


class Solution:
    def knapSack(self, weights, profit, capacity):
        rows = len(weights) + 1
        cols = capacity + 1
        dp = [[0 for _ in range(cols)] for _ in range(rows)]

        for i in range(1, rows):
            for j in range(1, cols):
                if weights[i - 1] < j:
                    dp[i][j] = max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weights[i - 1]])

                else:
                    dp[i][j] = dp[i - 1][j]

        print(dp)
        return dp[rows - 1][cols - 1]


obj = Solution()
obj.knapSack([10, 20, 30], [60, 100, 120], 50)
print(obj.knapSack([10, 20, 30], [60, 100, 120], 50))
