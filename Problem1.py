# // Time Complexity : O(N * W)
# // Space Complexity : O(N * W)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
        dp = [[-1 for _ in range(W+1)] for _ in range(len(val)+1)]
        # code here
        def helper(n, w):
            if n < 0 :
                return 0
            if w == 0:
                return 0
            # if w < 0:
            #     return -float('inf')
            if dp[n][w] != -1:
                return dp[n][w]
                
            include = 0
            if w-wt[n] >= 0:
                include = val[n] + helper(n-1, w - wt[n])
            exclude = helper(n-1, w)
            
            dp[n][w] = max(include, exclude)
            return dp[n][w]
        
        return helper(len(val)-1, W)