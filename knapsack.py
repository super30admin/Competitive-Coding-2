# Time Complexity : O(M*N) where M is no of weight, N is capacity
# Space Complexity : O(M*N) where M is no of weight, N is capacity //?
# Did this code successfully run on Leetcode : not in Leetcode, executed in PyCharm
# Any problem you faced while coding this : the video was very helpful

class Solution:
    def knapSack(self, capacity, weights, profit, n):

        dp = [[0 for x in range(capacity + 1)] for x in range(n + 1)]
        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    dp[i][w] = 0
                elif weights[i - 1] <= w:
                    dp[i][w] = max(profit[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
                else:
                    dp[i][w] = dp[i - 1][w]

        return dp[n][capacity]


# Driver program to test above function
r = Solution()
profit = [60, 100, 120]
weights = [10, 20, 30]
capacity = 50
n = len(profit)
print(r.knapSack(capacity, weights, profit, n))
