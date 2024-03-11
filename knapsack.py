# Time Complexity : O(n*w)
# Space Complexity : O(n*w)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def knapSack(self, w, wt, pro, n):
        dp = [[0]*(w+1) for _ in range(n+1)]

        for i in range(w+1):
            dp[0][i] = 0
        
        for i in range(1, n+1):
            for j in range(w+1):
                if(j < wt[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], pro[i-1]+dp[i-1][j-wt[i-1]])
        return dp[n][w]
                            
sc = Solution()
profit = [1,2,5,6] 
weight = [2,3,4,5] 
W = 8
n = len(profit) 
print(sc.knapSack(W, weight, profit, n))