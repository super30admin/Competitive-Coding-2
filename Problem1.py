#Function to return max value that can be put in knapsack of capacity W.

# time complexity : O(nW)
# space complexity: O(nw)

class Solution:
    
    def knapSack(self,W, wt, val, n):
       
        # code here
        p = [[0 for i in range(W+1)] for i in range(n+1)]
        
        for i in range(n+1):
            for j in range(W+1):
                if i == 0 or j == 0:
                    p[i][j] = 0
                elif wt[i-1] <= j:
                    p[i][j] = max(p[i-1][j], p[i-1][j - wt[i-1]] + val[i-1])
                else:
                    p[i][j] = p[i-1][j]
        
        return p[n][W]
                    
