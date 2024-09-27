"""
Time complexity O(n*W) where n is no of weight elements and W is capacity 
Space Complexity O(n*W)
"""

def knapSackDP(W, wei, val, i): 
    n=len(val)
    dp= [[0 for x in range(W + 1)] for x in range(n + 1)] 
  
    for i in range(n + 1): 
        for w in range(W + 1): 
            if i == 0 or w == 0: 
                dp[i][w] = 0
            elif wei[i-1] <= w:
                dp[i][w] = max(val[i-1]+ dp[i-1][w-wei[i-1]],dp[i-1][w]) 
            else: 
                dp[i][w] = dp[i-1][w] 
  
    return dp[n][W] 
  

val = [60, 100, 120] 
wei = [10, 20, 30] 
W = 50
print(knapSackDP(W, wei, val, 0)) 