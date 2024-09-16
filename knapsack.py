# Time Complexity : O(W*len(wt))
# Sapce Complexity : O(1) 

def knapSack(W, wt, val, n):
    dp = [0 for i in range(W + 1)]  
    for i in range(1, n + 1):  
        for w in range(W, 0, -1):  
            if wt[i-1] <= w:
                x =  dp[w]
                y = dp[w-wt[i-1]]+val[i-1]
                dp[w] = max(x, y)
    
    return dp[W]  


val = [50, 100, 120]
wt = [10, 20, 30]
W = 5
n = len(val)
print(knapSack(W, wt, val, n))
