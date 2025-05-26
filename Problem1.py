"""
We need a  2D DP table dp[i][w] - max value using first i items with capacity w.
If current item's weight wt[i-1] <= w, we can include or exclude it.
Take the max: dp[i][w] = max(dp[i-1][w], value[i-1] + dp[i-1][w - wt[i-1]])
"""
"""
Time Complexity: O(n × W) - 2D matrix
Space Complexity: O(n × W) - 2D matrix
"""

class Problem2:
    def knapsack(self,weights, values, W):
        n = len(weights)
        dp = [[0] * (W + 1) for _ in range(n + 1)]

        for i in range(1, n + 1):
            for w in range(W + 1):
                if weights[i-1] <= w:
                    dp[i][w] = max(dp[i-1][w], values[i-1] + dp[i-1][w - weights[i-1]])
                else:
                    dp[i][w] = dp[i-1][w]

        return dp[n][W]


if __name__=="__main__":
    weights = [2, 3, 4, 5]
    values = [3, 4, 5, 6]
    capacity = 5
    obj = Problem2()
    print(obj.knapsack(weights,values,capacity))
