# 0-1 knapsack https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
# Time complexity: O(n*m) => n = length of weights array, m = total target weight
# Space complexity: O(n) since, second dimension is a constant (W+1)
class Solution:
    def getMaxWeight(self, W, w, vals, n):
        dp = [ [ 0 for i in range(W + 1) ] for j in range(n + 1) ] 
        for i in range(n + 1):
            for j in range(W + 1):
                if j - w[i-1] >= 0:
                    dp[i][j] = max(dp[i-1][j], vals[i-1] + dp[i-1][j-w[i-1]])
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[n][W]
        
s = Solution()
# Driver code 
val = [60, 100, 120] 
wt = [10, 20, 30] 
W = 50
n = len(val) 
print(s.getMaxWeight(W, wt, val, n))