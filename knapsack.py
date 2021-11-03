# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Any problem you faced while coding this : No

def knapSack(W, wt, val, n):
    if n == 0 or W == 0:
        return 0
 
    if (wt[n-1] > W):
        return knapSack(W, wt, val, n-1)
    else:
        return max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),knapSack(W, wt, val, n-1))
