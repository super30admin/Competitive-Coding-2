# Time Complexity : O(wxn)
# Space Complexity : O(nxw)+O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use a 2D matrix and store all the maximum weights using recursion and return the maximum.

def knapsack(wt, W, val, n):
    if n==0 or W==0:
        return 0
    if t[n][W] != -1:
        return t[n][W]
    if(W>=wt[n-1]):
        t[n][W]=max(val[n-1]+knapsack(wt, W-wt[n-1], val,n-1), knapsack(wt, W, val, n-1))
    elif(W<wt[n-1]):
        t[n][W]=knapsack(wt, W, val, n-1)
    return t[n][W]


if __name__ == '__main__':
    p=[1,2,3]
    w=[4,2,1]
    n=len(w)
    W=4
    t=[[-1 for i in range(W+1)] for j in range(n+1)]
    print(knapsack(w, W, p, n))