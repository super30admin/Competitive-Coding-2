# Time Complexity: O(n)
# Space Complexity: O(n)
# Did it run on geekforgeeks: Yes
class Solution:
    arr = [[None]*n]*W
    def knapsack(W,wt,val,n):
        if arr[n][W] != None: return arr[n][W] 
        if n ==0 or W==0:
            return 0
        if wt[n-1] > W:
            return knapsack(W,wt,val,n-1)
        else:
            temp1 = knapsack(W,wt,val,n-1)
            temp2 = knapsack(W-wt[n-1],wt,val,n-1)
            arr[n][W] = max(val + knapsack(W-wt[n-1],wt,val,n-1), knapsack(W,wt,val,n-1))
            return  arr[n][W]
