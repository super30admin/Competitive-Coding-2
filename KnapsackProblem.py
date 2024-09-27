#  space complexity: O(m*n)
# time: O(mn)
#Ran on leetcode : Yes


class Solution:
    def find_max(self, profit, weight, cap):
        dp = [[0 for j in range(cap + 1)] for i in range(len(profit) + 1)]

        for i in range(1,len(dp)):
            for j in range(1,cap+1):
                if j < weight[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i-1]]+profit[i-1])
        return dp[len(profit)][cap]

        # dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + profit[i - 1])


obj = Solution()
print(obj.find_max([1,2,6], [2,3,5], 8))