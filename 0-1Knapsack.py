class Solution:
    def knapsack(self, weights: List[int], profits: List[int], capacity: int) -> int:
        if weights is None or profits is None or len(weights) == 0 or len(profits) == 0:
            return 0

        n = len(weights)
        dp = [[0] * (capacity + 1) for _ in range(n + 1)]
        for i in range(1, capacity + 1):
            dp[0][i] = 0

        for i in range(1, n + 1):  
            for j in range(1, capacity + 1):  
                if j < weights[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i - 1][j], profits[i - 1] + dp[i - 1][j - weights[i - 1]])

        return dp[n][capacity]
