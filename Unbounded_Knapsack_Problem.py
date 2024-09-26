
class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
        
        t=[[0 for _ in range(W+1)]for _ in range(n+1)]
        
                    
        for i in range(1,n+1):
            for j in range(1,W+1):
                if wt[i-1]<=j:
                    t[i][j]=max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j])
                else:
                    t[i][j]=t[i-1][j]
                    
        return t[n][W]