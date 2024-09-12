# Time Complexity : O(wn) where w is the max capacity and n in the number of objects.
# Space Complexity : O(wn) where w is the max capacity and n in the number of objects.
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : NA
class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
        
        
        # def helper(wt,val,returnedValue,index,remainingWeight,d):
        #     # base
        #     if(remainingWeight <=0 or index == len(wt)) :
        #         return returnedValue
            
        #     # logic
        #     # choose
        #     case1 = helper(wt,val,returnedValue + val[index],index+1,remainingWeight - wt[index])
            
        #     # not choose
        #     case2 = helper(wt,val,returnedValue,index+1,remainingWeight)
        
        #     return max(case1,case2)
        # return helper(wt,val,0,0,W)
        dp = [[0 for i in range(W+1)] for j in range(n+1)]
        for i in range(n+1):
            for j in range(W+1):
                if i == 0 or j == 0:
                    dp[i][j] = 0
                elif j < wt[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-wt[i-1]] + val[i-1])
        return dp[n][W]
