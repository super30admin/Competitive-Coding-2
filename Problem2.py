# Problem 2: Knapsack 0/1 
# Time Complexity: O(capacity * n) , n is len(weight)
# Space Complexity: O(capacity)

def maxProfit( weight, profit, capacity):
    dp=[[],[]]
    dp[0]=[0]*(capacity+1)
    dp[1]=dp[0].copy()
    for i in range(len(weight)):
        dp[0]=dp[1].copy()
        for j in range(capacity+1):
            if j-weight[i] >=0:
                dp[1][j]=max(dp[0][j], dp[0][j-weight[i]] + profit[i])
            else:
                dp[1][j]=dp[0][j]

    return dp[1][-1]

weight=[4,5,1]
profit=[1,2,3]
capacity=10
print(maxProfit(weight, profit, capacity))

            
        
    