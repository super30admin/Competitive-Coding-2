#Problem 2 : 0-1 Knapsack problem
#Time Complexity-O(capacity*n)
#Space Complexity-O(capacity*n)

class Solution:
    def knapsack(self, capacity, profit,weights,n) :
        #initial col and row 0 that's why capacity+1 and n+1
        dp=[[0 for _ in range(capacity+1)] for _ in range(n+1)]
        
        for i in range(n+1):
            for w in range(capacity+1):
                if w<weights[i-1]:
                    dp[i][w]=dp[i-1][w]
                else:
                    dp[i][w]=max(dp[i-1][w],dp[i-1][w-weights[i-1]]+profit[i-1])
        return dp[-1][-1]

capacity=8
profit=[1,2,6]
weights=[2,3,5]
n=3

sol=Solution()
res=sol.knapsack(capacity, profit,weights,n)
print(res)













