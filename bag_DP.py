# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def bag(self,weights,values, capacity):
        dp = [[-1 for j in range(capacity+1)]for i in range(len(weights)+1)]

        for j in range (0,capacity+1):
            dp[0][j] = 0

        for i in range(1,len(weights)+1):
            for j in range(0,capacity+1):
                if weights[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]])

        return dp[i][j]

obj = Solution()
weights=[1,2,3]
values=[6,10,12]
capacity = 5

max = obj.bag(weights,values,capacity)
print(max)
        