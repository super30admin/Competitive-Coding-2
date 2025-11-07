#Time Complexity: O(n*W)
#Space Complexity: O(n*W)


class Solution:
    def knapsack(self, W, val, wt):
        # code here

        # def helper(i,total,value):
        #     if total>W:
        #         return float("-inf")

        #     if i==len(wt):
        #         return value

        #     case0=helper(i+1,total,value)
        #     case1=helper(i+1,total+wt[i],value+val[i])
        #     return max(case0,case1)

        # return helper(0,0,0)

        dp = [[0] * (W + 1) for _ in range(len(wt) + 1)]

        for i in range(1, len(wt) + 1):
            for j in range(1, W + 1):
                if j < wt[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]])

        return dp[len(wt)][W]

