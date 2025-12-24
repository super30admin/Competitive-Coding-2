
class Solution:
    def finding_weights(self, profit :list[int], weight:list[int], capacity:int)-> int:
        n = len(weight) 
        
        dp = [[0 for i in range(capacity + 1)] for j in range(n + 1)]
        for i in range(1, n+1):
            for j in range(1, capacity+1):
                if weight[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j],profit[i-1] + dp[i-1][j-weight[i-1]])
        
        return dp[n][capacity]
    
solution = Solution()
print(solution.finding_weights([1,2,3],[4,5,1],4))