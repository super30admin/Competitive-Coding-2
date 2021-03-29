# Time Complexity : O(nk), where n is the number of items and k is the size of the knapsack
# Space Complexity : O(nk)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def knapsack(self, weights, profits, k):
        w, p = zip(*sorted(zip(weights, profits)))

        if k < w[0]:
            return 0

        dp = [[0 for i in range(k + 1)] for j in range(len(w) + 1)]

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < w[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + p[i - 1])

        return dp[-1][-1]


s = Solution()
w = [1, 2, 3]
p = 6, 10, 12
k = 5
print("Max profit:", s.knapsack(w, p, k))
