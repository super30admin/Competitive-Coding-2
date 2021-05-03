"""Knapsack problem - 
Time Complexity -> O(m *n)
Space Compelxity - O(m*n) m - length of weight list , n - Capacity

Approach -> Use dynamic Programming -> Bottom up 
"""

def knapSack(val, wt, cap): 
    dp = [[0 for _ in range(cap + 1)] for _ in range(len(wt)+ 1)] 
    

    #build table bottom up last cell contains the max profit
    for i in range(len(wt) + 1): 
        for j in range(cap + 1): 
            if i == 0 or j == 0: 
                dp[i][j] = 0
            elif wt[i-1] <= j: 
                dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]],  dp[i-1][j]) 
            else: 
                dp[i][j] = dp[i-1][j] 
  
    return dp[len(wt)][cap] 