# TC : O(W*len(wt))
# SC : O(1) - No Auxilary Space
def knapSack(W, wt, val, n):
    dp = [0 for i in range(W+1)]  
    for i in range(1, n+1):  
        for w in range(W, 0, -1):  
                                
            if wt[i-1] <= w:
        
                dp[w] = max(dp[w], dp[w-wt[i-1]]+val[i-1])
    return dp[W]  
 
 

val = [6, 10, 12]
wt = [1, 2, 3]
W = 5
n = len(val)
print(knapSack(W, wt, val, n))