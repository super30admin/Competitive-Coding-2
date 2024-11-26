class Solution:
    def knapsack(self, weights, values, capacity):
        if len(weights) == 0 or len(values) == 0 or capacity < 0:
            return 0
        n = len(weights)+1
        m = capacity+1
        dp = [[0 for _ in range(m)] for _ in range(n)]

        for i in range(1, n):
            for j in range(1, m):
                if j < weights[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(values[i-1]+dp[i-1]
                                   [j-weights[i-1]], dp[i-1][j])

        return dp[n-1][m-1]


solution = Solution()
print(solution.knapsack([1, 2, 3], [6, 10, 20], 5))
print(solution.knapsack([1, 2, 3], [6, 10, 20], 30))