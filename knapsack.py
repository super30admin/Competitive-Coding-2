"""
Question -  weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack
Eg - val = [60, 100, 120] 
wt = [10, 20, 30] 
W = 50 
Ans - 220
"""

"""
Logic - Why Dp - the idea to check out all the possible cases of taking an element or not taking an element
this gives rise to recursion and hence Dp.

Time Complexity - O(2^n)
Space Complexity - O(1)
"""

def knapsack(W,wt,val,n):
    if n ==0 or W==0:
        return 0
    
    #If this weight is greater than the capacity, it cannot be chosen
    if wt[n-1] > W:
        return knapsack(W,wt,val,n-1)
    
    else:
        #Choose or not choose the element
        #if we choose, subtract the item from capacity and reduce the total count
        #else if not choosing the element, reduce the count
        return max(val[n-1]+knapsack(W-wt[n-1],wt,val,n-1),knapsack(W,wt,val,n-1)) 


