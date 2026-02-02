class Solution:
    def knapsack(self, W, val, wt):
        # code here
        m=len(wt)
        dp = [[0] * (W+ 1) for _ in range(m + 1)]
         
        for i in range(1,m+1):
            for j in range(1,W+1):
                
                if j<wt[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]])
        
        return dp[m][W]
       