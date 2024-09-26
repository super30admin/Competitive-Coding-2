"""
Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : not on leetcode 
Any problem you faced while coding this: none
"""

class Solution:
    def maxVal(self, weights, values, W):
        if weights == None or values == None or len(weights) == 0 or len(values) == 0:
            return 0
        
        dp = [[0]*(max(weights)+1) for i in range(len(weights)+1)]
        
        for i in range(len(dp[0])):
            dp[0][i] = 0
        
        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if j < weights[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j-weights[i-1]] + values[i-1], dp[i-1][j])
            
        return dp[-1][-1]
    
s = Solution()
print(s.maxVal([1,2,3,4], [60,120,40,80], 5))