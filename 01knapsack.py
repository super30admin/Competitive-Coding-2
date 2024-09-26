'''Time Complexity: O(wt*capacity)
Sapce Complexity: O(wt*capacity)
'''
def Knapsack(wt, profit, capacity):
    
    dp=[[None for i in range(capacity+1)]for j in range(len(wt)+1)]
    
    for i in range(len(wt)+1):
        for j in range(capacity+1):
            if i==0 or j==0:
                dp[i][j]=0
            elif wt[i-1]>j:
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=max(dp[i-1][j], dp[i-1][j-wt[i-1]]+profit[i-1])
                
    return dp[len(wt)][capacity]
    
    

# Driver code
profit = [60, 100, 120]
wt = [10, 20, 30]
capacity = 50

print(Knapsack(wt, profit, capacity))


