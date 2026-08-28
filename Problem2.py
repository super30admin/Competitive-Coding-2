#Time Complexity : O(n*m)
#Space Complexity : O(n)
class Solution:
    @staticmethod
    def findMax(weights, profit, totalCapacity):
        n = totalCapacity
        m = len(weights)
        dp = [0] * (n + 1)

        for i in range(m):
            for j in range(n, weights[i] - 1, -1):
                dp[j] = max(dp[j], profit[i] + dp[j - weights[i]])

        return dp[n]
