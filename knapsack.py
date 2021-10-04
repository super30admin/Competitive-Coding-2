'''
Time Complexity: O(n * W)
Space Complexity O(n * W)
'''
def knapsack(val,wt,W,n):
   
    # Base Case
    if n == 0 or W == 0:
        return 0

    if dp[n][W]!=-1:
        return dp[n][W]

    #Choice Diagram
    if wt[n-1]>W:
        dp[n][W] = knapsack(val,wt,W,n-1)
        
        return dp[n][W]
    
    else:
        dp[n][W]=max(val[n-1]+knapsack(val,wt,W-wt[n-1],n-1),knapsack(val,wt,W,n-1))
        return dp[n][W]
        
val=[60,100,120]
wt=[10,20,30]
W=50
n=len(wt)
#dp[n][W]
dp=[[-1 for _ in range(W+1)]for _ in range(n+1)]
print(knapsack(val,wt,W,n))
