"""
Problem : 2

Time Complexity : O(W*n)
Space Complexity : O(W*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating a DP matrix and choosing the weight based on whether we add the item or not or we take the maximum weight between the two
at the end we take the maximum weight we could collect by retriving the value at the end of the DP matrix

"""

# Knapsack

class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
       
        dp=[[0 for _ in range(W+1)] for _ in range(n+1)]
        for i in range(1,n+1):
            for j in range(1,W+1):
                if wt[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]])
    
        return max(dp[-1])