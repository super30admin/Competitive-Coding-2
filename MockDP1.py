#  Time Complexity : O(M*N) where M is length of the weights and N is the capacity
#  Space Complexity: O(M*N) where M is length of the weights and N is the capacity

class Solution(object):
    def weightsProfits(self, weights, profits, cap):
        n = len(weights)

        if n ==0 or cap <= 0:
            return 0

        dp = [[0 for x in range(cap+1)] for x in range(n+1)]
        # dp = [[0] * (cap+1)] * (n+1)
        # print(dp)

        for i in range(1, n+1):
            for j in range(cap+1):
                if j < weights[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], (profits[i-1] + dp[i-1][j-weights[i-1]]))
        # print(dp)

        return dp[n][cap]


# Testing the above solution

sol = Solution()
weights = [1, 2, 3]
profits = [6, 10, 12]
cap = 5

print(sol.weightsProfits(weights, profits, cap))
