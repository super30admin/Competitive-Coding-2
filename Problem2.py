# Time Complexity : O(n*totalCapacity)
# Space Complexity : O(totalCapacity)
# Did this code successfully run on Leetcode :no
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# loop through the weights and total capacity
# looping through dp in reverse because the initial elements are changed
# for each element the max is dp[j-1] and profit of that element + dp[j-weight[i]] as we have to move weight[i] steps backward

class Solution:
    @staticmethod
    def findMax(weights, profit, totalCapacity):
        m = len(weights)
        dp = [0]*(totalCapacity+1)
        if m ==0:
            return 0
        for i in range(m):
            for j in range(totalCapacity,weights[i]-1,-1):
                dp[j] = max(dp[j],profit[i]+dp[j-weights[i]])
        return dp[totalCapacity]